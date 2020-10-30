package com.fitbit.api.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {

    private final String deviceVersion;

    private final String id;

    private final String lastSyncTime;

    private final String type;

    @JsonCreator
    public Device(@JsonProperty("deviceVersion") String deviceVersion, @JsonProperty("id") String id,
                  @JsonProperty("lastSyncTime") String lastSyncTime, @JsonProperty("type") String type) {
        this.deviceVersion = deviceVersion;
        this.id = id;
        this.lastSyncTime = lastSyncTime;
        this.type = type;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    public String getId() {
        return id;
    }

    public String getLastSyncTime() {
        return lastSyncTime;
    }

    public String getType() {
        return type;
    }
}
