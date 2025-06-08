package com.dean.hypertrophy9000.service;

import com.dean.hypertrophy9000.model.ActivityLevel;
import com.dean.hypertrophy9000.model.CalorieGoal;
import com.dean.hypertrophy9000.model.Sex;
import com.dean.hypertrophy9000.model.User;

import java.util.HashMap;
import java.util.Map;

public interface UserMetricsService {

    // Standard WHO-approved BMI formula.
    default double calculateBMI(User user) {
        double heightMeters = user.getHeightCm() / 100;
        return user.getWeightKg() / (heightMeters * heightMeters);
    }

    // Mifflin-St Jeor Equation (most accurate for modern body comp)
    default double calculateBMR(User user) {
        double bmr = (10 * user.getWeightKg()) +
                (6.25 * user.getHeightCm()) -
                (5 * user.getAge());
        if (user.getSex() == Sex.FEMALE) {
            bmr -= 161;
        } else {
            bmr += 5;
        }
        return bmr;
    }

    // Standard method
    default double calculateTDEE(User user) {
        double bmr = calculateBMR(user);
        double activityMultiplier = user.getActivityLevel().getMultiplier();
        return bmr * activityMultiplier;
    }

    default Map<String, Double> calculateAdvisedCalories(User user) {
        double tdee = calculateBMR(user) * user.getActivityLevel().getMultiplier();

        Map<String, Double> calories = new HashMap<>();
        calories.put("Maintenance", tdee);
        calories.put("Bulk (+250)", tdee + 250);
        calories.put("Cut - 1lb/week", tdee - 500);
        calories.put("Cut -2lb/week", tdee - 1000);

        return calories;
    }

    default double calculateBodyFatPercentage(User user) {
        double neck = user.getNeckSizeCm();
        double waist = user.getWaistSizeCm();
        double hip = user.getHipSizeCm();
        double height = user.getHeightCm();
        double bfPercentage;

        if (user.getSex() == Sex.FEMALE) {
            double value = waist + hip - neck;
            if (value <= 0 || height <= 0) return -1; // Invalid input
            bfPercentage = 163.205 * Math.log10(value)
                    - 97.684 * Math.log10(height)
                    - 78.387;
        } else {
            double value = waist - neck;
            if (value <= 0 || height <= 0) return -1; // Invalid input
            bfPercentage = 86.010 * Math.log10(value)
                    - 70.041 * Math.log10(height)
                    + 36.76;
        }

        return Math.round(bfPercentage * 100.0) / 100.0;
    }

    default double calculateFFMI(User user) {
        double bodyFatPercentage = calculateBodyFatPercentage(user);
        double bodyFatDecimal = bodyFatPercentage / 100.0;
        double leanMassKg = user.getWeightKg() * (1 - bodyFatDecimal);
        double heightM = user.getHeightCm() / 100;
        double ffmi = leanMassKg / (heightM * heightM);

        return Math.round(ffmi * 100.0) / 100.0;
    }

}
