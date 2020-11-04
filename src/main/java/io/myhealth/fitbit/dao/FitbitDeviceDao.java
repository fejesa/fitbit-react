package io.myhealth.fitbit.dao;

import com.fitbit.api.device.Device;
import io.myhealth.fitbit.api.FitbitException;
import io.myhealth.fitbit.transform.DeviceTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Component
public class FitbitDeviceDao implements DeviceDao {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final WebClient webClient;

    private final TokenDao tokenDao;

    public FitbitDeviceDao(@Value("${myhealth.fitbit.baseUri}") String uri, TokenDao tokenDao) {
        this.tokenDao = tokenDao;
        this.webClient = WebClient.create(uri);
    }

    @Override
    public Mono<Device> getDevice() {
        return getDeviceList().transform(new DeviceTransformer());
    }

    @Override
    public Mono<List<Device>> getDeviceList() {
        return  tokenDao.getAccessToken()
                .flatMap(rt -> webClient
                        .get()
                        .uri(buildDeviceUri())
                        .headers(h -> h.setBearerAuth(rt))
                        .retrieve()
                        .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new FitbitException("Client error during device list fetch")))
                        .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new FitbitException("Fitbit server error during device list fetch")))
                        .bodyToMono(new ParameterizedTypeReference<List<Device>>() {})
                        .doOnSuccess(t -> log.info("Device list is fetched"))
                        .doOnError(e -> log.error("Error during the device list fetch", e)));
    }

    private String buildDeviceUri() {
        return "/user/-/devices.json";
    }
}
