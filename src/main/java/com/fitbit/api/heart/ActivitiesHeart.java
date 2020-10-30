package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivitiesHeart {

    private final String dateTime;

    private final ActivitiesHeartRateValue value;

    @JsonCreator
    public ActivitiesHeart(@JsonProperty("dateTime") String dateTime, @JsonProperty("value") ActivitiesHeartRateValue value) {
        this.dateTime = dateTime;
        this.value = value;
    }

    public String getDateTime() {
        return dateTime;
    }

    public ActivitiesHeartRateValue getValue() {
        return value;
    }
}
