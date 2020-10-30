package com.fitbit.api.profile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private final int age;

    private final String dateOfBirth;

    private final String displayName;

    private final String distanceUnit;

    private final String firstName;

    private final String gender;

    private final String glucoseUnit;

    private final int height;

    private final String heightUnit;

    private final int weight;

    private final String weightUnit;

    @JsonCreator
    public User(@JsonProperty("age") int age, @JsonProperty("dateOfBirth") String dateOfBirth,
                @JsonProperty("displayName") String displayName, @JsonProperty("distanceUnit") String distanceUnit,
                @JsonProperty("firstName") String firstName, @JsonProperty("gender") String gender, @JsonProperty("glucoseUnit") String glucoseUnit,
                @JsonProperty("height") int height, @JsonProperty("heightUnit") String heightUnit,
                @JsonProperty("weight") int weight, @JsonProperty("weightUnit") String weightUnit) {
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.displayName = displayName;
        this.distanceUnit = distanceUnit;
        this.firstName = firstName;
        this.gender = gender;
        this.glucoseUnit = glucoseUnit;
        this.height = height;
        this.heightUnit = heightUnit;
        this.weight = weight;
        this.weightUnit = weightUnit;
    }

    public int getAge() {
        return age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getGlucoseUnit() {
        return glucoseUnit;
    }

    public int getHeight() {
        return height;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public int getWeight() {
        return weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }
}
