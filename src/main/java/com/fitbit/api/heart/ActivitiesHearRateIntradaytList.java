package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActivitiesHearRateIntradaytList {

    private final List<ActivitiesHeart> activitiesHeart;

    private final HeartRateIntradayList activitiesHeartIntraday;

    public ActivitiesHearRateIntradaytList(@JsonProperty("activities-heart") List<ActivitiesHeart> activitiesHeart,
                                           @JsonProperty("activities-heart-intraday") HeartRateIntradayList activitiesHeartIntraday) {
        this.activitiesHeart = activitiesHeart;
        this.activitiesHeartIntraday = activitiesHeartIntraday;
    }

    public List<ActivitiesHeart> getActivitiesHeart() {
        return activitiesHeart;
    }

    public HeartRateIntradayList getActivitiesHeartIntraday() {
        return activitiesHeartIntraday;
    }
}
