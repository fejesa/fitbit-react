package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActivitiesIntradayHeart {

    private final List<HeartRateZone> customHeartRateZones;

    private final List<HeartRateZone> heartRateZones;

    private final String dateTime;

    private final String value;

    @JsonCreator
    public ActivitiesIntradayHeart(@JsonProperty("customHeartRateZones") List<HeartRateZone> customHeartRateZones,
                                   @JsonProperty("heartRateZones") List<HeartRateZone> heartRateZones,
                                   @JsonProperty("dateTime") String dateTime,
                                   @JsonProperty("value") String value) {
        this.customHeartRateZones = customHeartRateZones;
        this.heartRateZones = heartRateZones;
        this.dateTime = dateTime;
        this.value = value;
    }

    public List<HeartRateZone> getCustomHeartRateZones() {
        return customHeartRateZones;
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
