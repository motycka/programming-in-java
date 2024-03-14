package com.harbourspace.tracker.exercise;

import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;

import java.util.Date;
import java.util.List;

public interface ExerciseService {
    List<Exercise> getExercises();

//    List<Exercise> getExerciseByFilter(Date date, Long activityId, Long duration);

//    List<Exercise> getExerciseByFilter(Date startDate, Date endDate, Long activityId, Long duration);

    List<Exercise> getExerciseByFilter(Date filterDate, Long activityId, Long duration);

    Exercise getExerciseById(long id);

    List<Exercise> getExerciseByActivityId(long id);

    Exercise createExercise(NewExercise exercise);

    Exercise updateExercise(Exercise exercise);

    void deleteExercise(long id);

}
