package com.example.rewardpoints.model;

import java.util.HashMap;
import java.util.Map;

public class CustomerRewards {
    private final Map<String, Integer> monthlyPoints = new HashMap<>();
    private int totalPoints;

    public void addMonthlyPoints(String month, int points) {
        monthlyPoints.merge(month, points, Integer::sum);
        totalPoints += points;
    }

    public Map<String, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    @Override
    public String toString() {
        return "CustomerRewards{" +
                "monthlyPoints=" + monthlyPoints +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
