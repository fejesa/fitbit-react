package io.myhealth.fitbit.dao;

import com.fitbit.api.heart.ActivitiesHeart;
import com.fitbit.api.heart.ActivitiesIntradayHeartList;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MeasurementDao {

    Mono<List<ActivitiesHeart>> getActivitiesHeartList(FitbitHeartListRequest request);

    Mono<ActivitiesIntradayHeartList> getActivitiesIntradayHeartList(FitbitIntradayHeartListRequest request);

}
