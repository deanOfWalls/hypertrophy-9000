package com.dean.hypertrophy9000.controller;

import com.dean.hypertrophy9000.model.User;
import com.dean.hypertrophy9000.service.UserMetricsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user-metrics/")
public class UserMetricsController {

    private final UserMetricsService userMetricsService;

    public UserMetricsController(UserMetricsService userMetricsService) {
        this.userMetricsService = userMetricsService;
    }

    @PostMapping("/complete-metrics")
    public ResponseEntity<Map<String, Object>> calculateMetrics(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        result.put("BMI", userMetricsService.calculateBMI(user));
        result.put("TDEE", userMetricsService.calculateTDEE(user));
        result.put("BodyFat", userMetricsService.calculateBodyFatPercentage(user));
        result.put("FFMI", userMetricsService.calculateFFMI(user));
        result.put("Calories", userMetricsService.calculateAdvisedCalories(user));
        return ResponseEntity.ok(result);
    }
}
