package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HeartRate {

    private final String time;

    private final int value;

    @JsonCreator
    public HeartRate(@JsonProperty("time") String time, @JsonProperty("value") int value) {
        this.time = time;
        this.value = value;
    }

    public String getTime() {
        return time;
    }

    public int getValue() {
        return value;
    }
}
