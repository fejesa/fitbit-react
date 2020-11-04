package io.myhealth.fitbit.transform;

import com.fitbit.api.device.Device;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

public class DeviceTransformer implements Function<Mono<List<Device>>, Mono<Device>> {

    @Override
    public Mono<Device> apply(Mono<List<Device>> devices) {
        return devices.map(d -> d.isEmpty() ? Device.empty() : d.get(0));
    }
}
