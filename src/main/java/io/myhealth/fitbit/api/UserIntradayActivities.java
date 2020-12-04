package io.myhealth.fitbit.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitbit.api.heart.ActivitiesIntradayHeart;
import com.fitbit.api.heart.ActivitiesIntradayHeartRateDataset;
import com.fitbit.api.profile.User;

import java.util.List;

public class UserIntradayActivities {

    private final User user;

    private final List<ActivitiesIntradayHeart> activities;

    private final ActivitiesIntradayHeartRateDataset activitiesDataset;

    @JsonCreator
    public UserIntradayActivities(@JsonProperty("user") User user,
                                  @JsonProperty("activities") List<ActivitiesIntradayHeart> activities,
                                  @JsonProperty("dataset") ActivitiesIntradayHeartRateDataset activitiesDataset) {
        this.user = user;
        this.activities = activities;
        this.activitiesDataset = activitiesDataset;
    }

    public User getUser() {
        return user;
    }

    public List<ActivitiesIntradayHeart> getActivities() {
        return activities;
    }

    public ActivitiesIntradayHeartRateDataset getActivitiesDataset() {
        return activitiesDataset;
    }
}
