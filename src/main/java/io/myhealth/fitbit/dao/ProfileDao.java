package io.myhealth.fitbit.dao;

import com.fitbit.api.profile.Profile;
import reactor.core.publisher.Mono;

public interface ProfileDao {

    Mono<Profile> getProfile();
}
