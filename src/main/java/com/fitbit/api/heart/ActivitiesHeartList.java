package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActivitiesHeartList {

    private final List<ActivitiesHeart> activitiesHeart;

    @JsonCreator
    public ActivitiesHeartList(@JsonProperty("activities-heart") List<ActivitiesHeart> activitiesHeart) {
        this.activitiesHeart = activitiesHeart;
    }

    public List<ActivitiesHeart> getActivitiesHeart() {
        return activitiesHeart;
    }
}
