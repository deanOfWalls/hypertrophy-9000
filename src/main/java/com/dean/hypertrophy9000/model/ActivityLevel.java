package com.dean.hypertrophy9000.model;

public enum ActivityLevel {
    // little to no exercise
    SEDENTARY(1.2),

    // trains 3-5 times a week
    MODERATE(1.55),

    // trains 6-7+ times/week
    VERY_ACTIVE(1.9);

    private final double multiplier;

    ActivityLevel(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
