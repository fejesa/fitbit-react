package io.myhealth.fitbit.service;

import io.myhealth.fitbit.dao.MeasurementDao;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class FitbitHeartService implements HeartService {

    private final MeasurementDao measurementDao;

    public FitbitHeartService(MeasurementDao measurementDao) {
        this.measurementDao = measurementDao;
    }

    @Override
    public Mono<ServerResponse> getHeartRateTimeSeries(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> getHeartRateIntradayTimeSeries(ServerRequest request) {
        return null;
    }
}
