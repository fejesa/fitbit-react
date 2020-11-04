package io.myhealth.fitbit.dao;

import com.fitbit.api.profile.User;
import reactor.core.publisher.Mono;

public interface UserDao {

    Mono<User> getUser();
}
