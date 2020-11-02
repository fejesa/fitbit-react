package io.myhealth.fitbit.dao;

import com.fitbit.api.device.Device;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DeviceDao {

    Mono<List<Device>> getDeviceList();
}
