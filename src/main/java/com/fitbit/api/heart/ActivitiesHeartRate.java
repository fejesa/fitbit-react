package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActivitiesHeartRate {

   private final List<HeartRateZone> heartRateZones;

    private final int restingHeartRate;

    @JsonCreator
    public ActivitiesHeartRate(@JsonProperty("heartRateZones") List<HeartRateZone> heartRateZones,
                               @JsonProperty("restingHeartRate") int restingHeartRate) {
        this.heartRateZones = heartRateZones;
        this.restingHeartRate = restingHeartRate;
    }

    public List<HeartRateZone> getHeartRateZones() {
        return heartRateZones;
    }

    public int getRestingHeartRate() {
        return restingHeartRate;
    }
}
