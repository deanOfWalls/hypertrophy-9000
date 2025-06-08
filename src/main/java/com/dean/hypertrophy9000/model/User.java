package com.dean.hypertrophy9000.model;

public class User {
    private String username;
    private Boolean isMetricUser;
    private int age;
    private double heightCm;
    private double weightKg;
    private double neckSizeCm;
    private double waistSizeCm;
    private double hipSizeCm;
    private ActivityLevel activityLevel = ActivityLevel.SEDENTARY;
    private Sex sex;

    public User(String username, Boolean isMetricUser, int age, double heightCm, double weightKg, double neckSizeCm, double waistSizeCm, double hipSizeCm, ActivityLevel activityLevel, Sex sex) {
        this.username = username;
        this.isMetricUser = isMetricUser;
        this.age = age;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.neckSizeCm = neckSizeCm;
        this.waistSizeCm = waistSizeCm;
        this.hipSizeCm = hipSizeCm;
        this.activityLevel = activityLevel;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getMetricUser() {
        return isMetricUser;
    }

    public void setMetricUser(Boolean metricUser) {
        isMetricUser = metricUser;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(double heightCm) {
        this.heightCm = heightCm;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getNeckSizeCm() {
        return neckSizeCm;
    }

    public void setNeckSizeCm(double neckSizeCm) {
        this.neckSizeCm = neckSizeCm;
    }

    public double getWaistSizeCm() {
        return waistSizeCm;
    }

    public void setWaistSizeCm(double waistSizeCm) {
        this.waistSizeCm = waistSizeCm;
    }

    public double getHipSizeCm() {
        return hipSizeCm;
    }

    public void setHipSizeCm(double hipSizeCm) {
        this.hipSizeCm = hipSizeCm;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
