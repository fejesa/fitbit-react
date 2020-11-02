package io.myhealth.fitbit.api;

import com.fitbit.api.device.Device;
import com.fitbit.api.heart.ActivitiesIntradayHeartList;
import com.fitbit.api.profile.Profile;

import java.util.List;

public class UserIntradayActivities {

    private final Profile profile;

    private final List<Device> deviceList;

    private final ActivitiesIntradayHeartList activitiesIntradayHeartList;

    public UserIntradayActivities(Profile profile, List<Device> deviceList, ActivitiesIntradayHeartList activitiesIntradayHeartList) {
        this.profile = profile;
        this.deviceList = deviceList;
        this.activitiesIntradayHeartList = activitiesIntradayHeartList;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public ActivitiesIntradayHeartList getActivitiesIntradayHeartList() {
        return activitiesIntradayHeartList;
    }
}
