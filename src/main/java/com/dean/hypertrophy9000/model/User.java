package com.dean.hypertrophy9000.model;

public class User extends AbstractUser{
    public User(String username, Boolean isMetricUser, int age, double heightCm, double weightKg, double neckSizeCm, double waistSizeCm, double hipSizeCm, ActivityLevel activityLevel, Sex sex) {
        super(username, isMetricUser, age, heightCm, weightKg, neckSizeCm, waistSizeCm, hipSizeCm, activityLevel, sex);
    }
}
