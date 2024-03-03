package com.harbourspace.tracker.exercise.model;


import java.time.ZonedDateTime;

public record Exercise(
        Long id,
        Long userId,
        Long activityId,
        ZonedDateTime startTime,
        Double duration,
        Double caloriesBurned
) {
    public Exercise withId(Long id) {
        return new Exercise(id, userId, activityId, startTime, duration, caloriesBurned);
    }
}
