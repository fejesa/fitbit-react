package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivitiesIntradayHeart {

    private final String dateTime;

    private final ActivitiesHeartRate value;

    @JsonCreator
    public ActivitiesIntradayHeart(@JsonProperty("dateTime") String dateTime,
                                   @JsonProperty("value") ActivitiesHeartRate value) {
        this.dateTime = dateTime;
        this.value = value;
    }

    public String getDateTime() {
        return dateTime;
    }

    public ActivitiesHeartRate getValue() {
        return value;
    }
}
