package io.myhealth.fitbit.api;

import com.fitbit.api.device.Device;
import com.fitbit.api.heart.ActivitiesHeart;
import com.fitbit.api.profile.User;

import java.util.List;

public class UserActivities {

    private final User user;

    private final List<ActivitiesHeart> activitiesHeartList;

    private final Device device;

    public UserActivities(User user, List<ActivitiesHeart> activitiesHeartList, Device device) {
        this.user = user;
        this.activitiesHeartList = activitiesHeartList;
        this.device = device;
    }

    public User getUser() {
        return user;
    }

    public List<ActivitiesHeart> getActivitiesHeartList() {
        return activitiesHeartList;
    }

    public Device getDevice() {
        return device;
    }
}
