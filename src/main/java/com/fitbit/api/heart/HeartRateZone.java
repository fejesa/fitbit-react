package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HeartRateZone {

    private final double caloriesOut;

    private final int max;

    private final int min;

    private final int minutes;

    private final String name;

    @JsonCreator
    public HeartRateZone(@JsonProperty("caloriesOut") double caloriesOut, @JsonProperty("max") int max,
                         @JsonProperty("min") int min, @JsonProperty("minutes") int minutes, @JsonProperty("name") String name) {
        this.caloriesOut = caloriesOut;
        this.max = max;
        this.min = min;
        this.minutes = minutes;
        this.name = name;
    }

    public double getCaloriesOut() {
        return caloriesOut;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getName() {
        return name;
    }
}
