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
    default double calculateTDEE(User user){
        double bmr = calculateBMR(user);
        double activityMultiplier = user.getActivityLevel().getMultiplier();
        return bmr * activityMultiplier;
    }

    default Map<String, Double> calculateAdvisedCalories(User user){
        double tdee = calculateBMR(user) * user.getActivityLevel().getMultiplier();

        Map<String, Double> calories = new HashMap<>();
        calories.put("Maintenance", tdee);
        calories.put("Bulk (+250)", tdee + 250);
        calories.put("Cut - 1lb/week", tdee - 500);
        calories.put("Cut -2lb/week", tdee - 1000);

        return calories;
    }






}
