package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActivitiesHeartRateIntraday {

    private final List<ActivitiesHeart> activitiesHeart;

    private final ActivitiesHeartRateIntradayDataset activitiesHeartRateIntradayDataset;

    @JsonCreator
    public ActivitiesHeartRateIntraday(@JsonProperty("activities-heart") List<ActivitiesHeart> activitiesHeart,
                                       @JsonProperty("activities-heart-intraday") ActivitiesHeartRateIntradayDataset activitiesHeartIntraday) {
        this.activitiesHeart = activitiesHeart;
        this.activitiesHeartRateIntradayDataset = activitiesHeartIntraday;
    }

    public List<ActivitiesHeart> getActivitiesHeart() {
        return activitiesHeart;
    }

    public ActivitiesHeartRateIntradayDataset getActivitiesHeartRateIntradayDataset() {
        return activitiesHeartRateIntradayDataset;
    }
}
