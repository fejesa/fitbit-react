package io.myhealth.fitbit.api;

import com.fitbit.api.device.Device;
import com.fitbit.api.heart.ActivitiesHeartList;
import com.fitbit.api.profile.Profile;

import java.util.List;

public class UserActivities {

    private final Profile profile;

    private final ActivitiesHeartList activitiesHeartList;

    private final List<Device> deviceList;

    public UserActivities(Profile profile, ActivitiesHeartList activitiesHeartList, List<Device> deviceList) {
        this.profile = profile;
        this.activitiesHeartList = activitiesHeartList;
        this.deviceList = deviceList;
    }

    public Profile getProfile() {
        return profile;
    }

    public ActivitiesHeartList getActivitiesHeartList() {
        return activitiesHeartList;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }
}
