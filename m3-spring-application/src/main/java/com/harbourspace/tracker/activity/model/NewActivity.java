package com.harbourspace.tracker.activity.model;

public record NewActivity(
        Long userId,
        String name,
        Double kcalPerMinute
) {
    public Activity toActivity(long id) {
        return new Activity(id, userId, name, kcalPerMinute);
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
