package com.harbourspace.tracker.activity.model;

public record NewActivity(
        Long userId,
        String name,
        String type,
        Double kcalPerMinute
) {
    public Activity toActivity(long id) {
        return new Activity(id, userId, name, type, kcalPerMinute);
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
