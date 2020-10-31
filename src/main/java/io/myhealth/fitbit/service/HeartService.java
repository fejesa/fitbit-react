package io.myhealth.fitbit.service;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface HeartService {

    /**
     * Provides list of heart rates in the default and/or custom heart zones in the given period.
     *
     * @param request Contains the period
     * @see io.myhealth.fitbit.dao.FitbitHeartListRequest
     */
    Mono<ServerResponse> getHeartRateTimeSeries(ServerRequest request);

    /**
     * Provides the full intraday time series data set in a given time period
     *
     * @param request Contains the time range and detail level.
     * @see io.myhealth.fitbit.dao.FitbitHeartRateRequest
     */
    Mono<ServerResponse> getHeartRateIntradayTimeSeries(ServerRequest request);
}
