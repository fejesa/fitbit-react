package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActivitiesIntradayHeartList {

    private final List<ActivitiesIntradayHeart> activitiesHeart;

    private final ActivitiesIntradayHeartRateDataset activitiesIntradayHeartRateDataset;

    @JsonCreator
    public ActivitiesIntradayHeartList(@JsonProperty("activities-heart") List<ActivitiesIntradayHeart> activitiesHeart,
                                       @JsonProperty("activities-heart-intraday") ActivitiesIntradayHeartRateDataset activitiesHeartIntraday) {
        this.activitiesHeart = activitiesHeart;
        this.activitiesIntradayHeartRateDataset = activitiesHeartIntraday;
    }

    public List<ActivitiesIntradayHeart> getActivitiesHeart() {
        return activitiesHeart;
    }

    public ActivitiesIntradayHeartRateDataset getActivitiesHeartRateIntradayDataset() {
        return activitiesIntradayHeartRateDataset;
    }
}
