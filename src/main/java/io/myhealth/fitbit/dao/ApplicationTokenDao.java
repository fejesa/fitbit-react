package io.myhealth.fitbit.dao;

import io.myhealth.fitbit.model.ApplicationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ApplicationTokenDao implements TokenDao {

    @Value("${myhealth.fitbit.tokenFile}")
    private String tokenFile;

    @Override
    public Mono<String> getAccessToken() {
        return ApplicationToken
                .read(tokenFile)
                .map(ApplicationToken::getAccessToken);
    }
}
