package com.harbourspace.tracker.exercise;

import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.error.AuthorizationException;
import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final AuthorizationService authorizationService;

    public ExerciseService(ExerciseRepository exerciseRepository, AuthorizationService authorizationService) {
        this.exerciseRepository = exerciseRepository;
        this.authorizationService = authorizationService;
    }

    public List<Exercise> getExercises() {
        return exerciseRepository.selectAll(getCurrentUserId());
    }

    public Exercise getExerciseById(Long id) {
        return exerciseRepository.selectById(getCurrentUserId(), id);
    }

    public Exercise createExercise(NewExercise exercise) {

        if (exercise.userId() != getCurrentUserId()) {
            throw new AuthorizationException("User is not allowed to create exercise for another user");
        }

        return exerciseRepository.insert(exercise);
    }

    public Exercise updateExercise(Exercise exercise) {
        if (exercise.userId() != getCurrentUserId()) {
            throw new AuthorizationException("User is not allowed to update exercise for another user");
        }

        return exerciseRepository.update(getCurrentUserId(), exercise);
    }

    public void deleteExercise(Long id) {
//        if (exercise.userId() != getCurrentUserId()) {
//            throw new AuthorizationException("User is not allowed to create exercise for another user");
//        }

        exerciseRepository.delete(getCurrentUserId(), id);
    }

    private long getCurrentUserId() {
        return authorizationService.getCurrentUser().id();
    }

}
