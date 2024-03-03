package com.harbourspace.tracker.activity.model;

public record NewActivity(
        Long userId,
        ActivityType type,
        String name,
        Double kcalPerMinute
) {
    public Activity toActivity(long id) {
        return new Activity(id, userId, type, name, kcalPerMinute);
    }
}

