package io.myhealth.fitbit.transform;

import com.fitbit.api.profile.Profile;
import com.fitbit.api.profile.User;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class ProfileTransformer implements Function<Mono<Profile>, Mono<User>> {

    @Override
    public Mono<User> apply(Mono<Profile> profile) {
        return profile.map(Profile::getUser);
    }
}
