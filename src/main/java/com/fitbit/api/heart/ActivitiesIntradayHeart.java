package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActivitiesIntradayHeart {

    private final List<HeartRateZone> heartRateZones;

    private final String dateTime;

    private final String value;

    @JsonCreator
    public ActivitiesIntradayHeart(@JsonProperty("heartRateZones") List<HeartRateZone> heartRateZones,
                                   @JsonProperty("dateTime") String dateTime,
                                   @JsonProperty("value") String value) {
        this.heartRateZones = heartRateZones;
        this.dateTime = dateTime;
        this.value = value;
    }

    public List<HeartRateZone> getHeartRateZones() {
        return heartRateZones;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getValue() {
        return value;
    }
}
