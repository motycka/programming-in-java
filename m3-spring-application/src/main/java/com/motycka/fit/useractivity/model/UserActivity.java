package com.motycka.fit.useractivity.model;


import java.time.ZonedDateTime;

record UserActivity(
        Long id,
        Long userId,
        Long activityId,
        ZonedDateTime startTime,
        Double duration,
        Double caloriesBurned
) {
    public UserActivity copy(Long id) {
        return new UserActivity(id, userId, activityId, startTime, duration, caloriesBurned);
    }
}
