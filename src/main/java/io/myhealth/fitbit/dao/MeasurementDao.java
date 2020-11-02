package io.myhealth.fitbit.dao;

import com.fitbit.api.heart.ActivitiesHeartList;
import com.fitbit.api.heart.ActivitiesIntradayHeartList;
import reactor.core.publisher.Mono;

public interface MeasurementDao {

    Mono<ActivitiesHeartList> getActivitiesHeartList(FitbitHeartListRequest request);

    Mono<ActivitiesIntradayHeartList> getActivitiesIntradayHeartList(FitbitIntradayHeartListRequest request);

}
