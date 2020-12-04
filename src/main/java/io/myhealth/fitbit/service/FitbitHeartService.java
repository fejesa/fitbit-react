package io.myhealth.fitbit.service;

import io.myhealth.fitbit.api.UserActivities;
import io.myhealth.fitbit.api.UserIntradayActivities;
import io.myhealth.fitbit.dao.*;
import io.myhealth.fitbit.transform.DateTimeTransformer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Component
public class FitbitHeartService implements HeartService {

    private final MeasurementDao measurementDao;

    private final UserDao userDao;

    private final DeviceDao deviceDao;

    public FitbitHeartService(MeasurementDao measurementDao, UserDao userDao, DeviceDao deviceDao) {
        this.measurementDao = measurementDao;
        this.userDao = userDao;
        this.deviceDao = deviceDao;
    }

    @Override
    public Mono<ServerResponse> getUserActivities(ServerRequest request) {
        var heartList = measurementDao.getActivitiesHeartList(heartListRequest(request));
        var deviceList = deviceDao.getDevice();
        var profile = userDao.getUser();

        return Mono.zip(profile, heartList, deviceList)
                .flatMap(data -> Mono.just(new UserActivities(data.getT1(), data.getT2(), data.getT3())))
                .flatMap(ServerResponse.ok()::bodyValue)
                .switchIfEmpty(ServerResponse.badRequest().build());
    }

    @Override
    public Mono<ServerResponse> getUserIntradayActivities(ServerRequest request) {
        var profile = userDao.getUser();
        var heartList = measurementDao.getActivitiesIntradayHeartList(intradayHeartListRequest(request));
        return Mono.zip(profile, heartList)
                .flatMap(data -> Mono.just(new UserIntradayActivities(data.getT1(), data.getT2().getActivitiesHeart(), data.getT2().getActivitiesHeartRateIntradayDataset())))
                .flatMap(ServerResponse.ok()::bodyValue)
                .switchIfEmpty(ServerResponse.badRequest().build());
    }

    private FitbitHeartListRequest heartListRequest(ServerRequest request) {
        var from = request.queryParam("from")
                .map(DateTimeTransformer::fromString)
                .orElseGet(() -> LocalDate.now().minusWeeks(1));
        var to = request.queryParam("to")
                .map(DateTimeTransformer::fromString)
                .orElseGet(LocalDate::now);

        return new FitbitHeartListRequest(from, to);
    }

    private FitbitIntradayHeartListRequest intradayHeartListRequest(ServerRequest request) {
        var date = request.queryParam("date")
                .map(DateTimeTransformer::fromString)
                .orElseGet(() -> LocalDate.now());
        return new FitbitIntradayHeartListRequest(date, "1min");
    }
}
