package com.motycka.fit.activity.model;

public record ActivityType(
        Long id,
        String name,
        Double kcalPerMinute
) {
    public ActivityType copy(long id) {
        return new ActivityType(id, name, kcalPerMinute);
    }
}
