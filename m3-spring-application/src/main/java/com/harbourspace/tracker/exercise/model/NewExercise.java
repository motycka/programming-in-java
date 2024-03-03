package com.harbourspace.tracker.exercise.model;


import java.time.ZonedDateTime;

public record NewExercise(
        Long userId,
        Long activityId,
        ZonedDateTime startTime,
        Double duration
) {
    public Exercise toExercise(long id, double kcalBurned) {
        return new Exercise(id, userId, activityId, startTime, duration, kcalBurned);
    }
}
