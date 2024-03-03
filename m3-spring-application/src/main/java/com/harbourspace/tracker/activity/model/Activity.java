package com.harbourspace.tracker.activity.model;

public record Activity(
        Long id,
        Long userId,
        ActivityType type,
        String name,
        Double kcalPerMinute
) {
    public Activity withUserId(long userId) {
        return new Activity(id, userId, type, name, kcalPerMinute);
    }
}

