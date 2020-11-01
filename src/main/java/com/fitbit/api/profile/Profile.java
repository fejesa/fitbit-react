package com.fitbit.api.profile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile {

    private final User user;

    @JsonCreator
    public Profile(@JsonProperty("user") User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
