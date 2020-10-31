package io.myhealth.fitbit.dao;

import reactor.core.publisher.Mono;

public interface TokenDao {

    Mono<String> getAccessToken();

}
