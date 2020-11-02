package io.myhealth.fitbit.dao;

import com.fitbit.api.profile.Profile;
import io.myhealth.fitbit.api.FitbitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;

@Component
public class FitbitProfileDao implements ProfileDao {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final WebClient webClient;

    private final TokenDao tokenDao;

    public FitbitProfileDao(@Value("${myhealth.fitbit.baseUri}") String uri, TokenDao tokenDao) {
        this.tokenDao = tokenDao;
        this.webClient = WebClient.create(uri);
    }

    @Override
    public Mono<Profile> getProfile() {
        return  tokenDao.getAccessToken()
                .flatMap(rt -> webClient
                        .get()
                        .uri(buildProfileUri())
                        .headers(h -> h.setBearerAuth(rt))
                        .retrieve()
                        .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new FitbitException("Client error during profile fetch")))
                        .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new FitbitException("Fitbit server error during profile fetch")))
                        .bodyToMono(Profile.class)
                        .doOnSuccess(t -> log.info("Profile is fetched"))
                        .doOnError(e -> log.error("Error during the profile fetch", e)));
    }

    private String buildProfileUri() {
        return "/user/-/profile.json";
    }
}
