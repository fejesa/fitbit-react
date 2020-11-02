package io.myhealth.fitbit.dao;

import com.fitbit.api.oauth.Token;
import io.myhealth.fitbit.model.ApplicationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.util.Base64;

@Component
@EnableScheduling
public class FitbitTokenFetcher implements TokenFetcher {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${fitbit.api.tokenHost}")
    private String tokenHost;

    @Value("${fitbit.api.clientId}")
    private String clientId;

    @Value("${fitbit.api.clientSecret}")
    private String clientSecret;

    @Value("${myhealth.fitbit.tokenFile}")
    private String tokenFile;

    private WebClient webClient;

    @Override
    @Scheduled(fixedRate = 6L * 3600 * 1000)
    public void refreshToken() {

        Mono<ApplicationToken> result = ApplicationToken
                .read(tokenFile)
                .flatMap(applicationToken -> webClient
                        .post()
                        .uri("/oauth2/token")
                        .headers(h -> {
                            h.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                            h.setBasicAuth(getCredentials());
                        })
                        .body(createBodyInserter(applicationToken.getRefreshToken()))
                        .exchange()
                        .flatMap(response -> response.bodyToMono(Token.class))
                        .map(t -> new ApplicationToken(t.getAccessToken(), t.getRefreshToken(), getExpirationTime(t.getExpiresIn())))
                        .subscribeOn(Schedulers.elastic())
                        .doOnSuccess(t -> log.info("Token successfully refreshed"))
                        .doOnError(e -> log.error("Token fetch error", e))
                );

        result.subscribe(this::writeToken);
    }

    private BodyInserters.FormInserter<String> createBodyInserter(String token) {
        MultiValueMap<String, String> requestParams= new LinkedMultiValueMap<>();
        requestParams.add("grant_type", "refresh_token");
        requestParams.add("refresh_token", token);
        return BodyInserters.fromFormData(requestParams);
    }

    private String getCredentials() {
        return Base64.getEncoder()
                .encodeToString((clientId + ":" + clientSecret).getBytes());
    }

    @PostConstruct
    private void init() {
        webClient = WebClient.create(tokenHost);
    }

    private LocalDateTime getExpirationTime(int offset) {
        return LocalDateTime.now().plusSeconds(offset);
    }

    private void writeToken(ApplicationToken token) {
        try {
            ApplicationToken.writeToken(token, tokenFile);
        } catch (IOException e) {
            log.error("Token file error", e);
        }
    }
}
