package com.fitbit.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitbit.api.device.Device;
import com.fitbit.api.heart.ActivitiesHeartRateIntraday;
import com.fitbit.api.heart.ActivitiesHeartList;
import com.fitbit.api.profile.Profile;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SampleDataLoaderTest {

    @Test
    public void loadActivitiesHeartList() throws Exception {
        URL resource = SampleDataLoaderTest.class.getResource("/sample/heart-rate-time-series.json");
        ActivitiesHeartList heartList = new ObjectMapper().readValue(resource, ActivitiesHeartList.class);
        assertNotNull(heartList);
        assertEquals(3, heartList.getActivitiesHeart().size());
    }

    @Test
    public void loadProfile() throws Exception {
        URL resource = SampleDataLoaderTest.class.getResource("/sample/profile.json");
        Profile profile = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(resource, Profile.class);
        assertNotNull(profile);
        assertNotNull(profile.getUser());
        assertEquals(18, profile.getUser().getAge());
    }

    @Test
    public void loadDevices() throws Exception {
        URL resource = SampleDataLoaderTest.class.getResource("/sample/devices.json");
        List<Device> devices = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(resource, new TypeReference<List<Device>>() { });
        assertNotNull(devices);
        assertEquals(1, devices.size());
        assertTrue("Charge 4".equals(devices.get(0).getDeviceVersion()));
    }

    @Test
    public void loadActivitiesHearRateIntradaytList() throws Exception {
        URL resource = SampleDataLoaderTest.class.getResource("/sample/heart-rate-intraday.json");
        ActivitiesHeartRateIntraday heartList = new ObjectMapper().readValue(resource, ActivitiesHeartRateIntraday.class);
        assertNotNull(heartList);
        assertFalse(heartList.getActivitiesHeart().isEmpty());
        assertFalse(heartList.getActivitiesHeartRateIntradayDataset().getDataset().isEmpty());
    }
}
