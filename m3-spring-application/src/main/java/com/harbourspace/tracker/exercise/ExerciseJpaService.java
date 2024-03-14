package com.harbourspace.tracker.exercise;


import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.error.AuthorizationException;
import com.harbourspace.tracker.error.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Service
public class ExerciseJpaService implements ExerciseService {

    private final Logger logger = LoggerFactory.getLogger(ExerciseJpaService.class);

    private final ExerciseJpaRepository exerciseRepository;
    private final AuthorizationService authorizationService;

    public ExerciseJpaService(ExerciseJpaRepository exerciseRepository, AuthorizationService authorizationService) {
        this.exerciseRepository = exerciseRepository;
        this.authorizationService = authorizationService;
    }
    @Override
    public List<Exercise> getExercises() {
        if (authorizationService.isSystem()) {
            logger.debug("Getting all exercises");
            return exerciseRepository.findAll().stream().map(ExerciseJpaService::toExercise).toList();
        } else throw unauthorized();
    }


//    @Override
//    public List<Exercise> getExerciseByFilter(Date date, Long activityId, Long duration) {
//        if (authorizationService.isSystem()) {
//            logger.debug("Getting exercises " + date + activityId + duration);
//            return exerciseRepository.selectByFilter(date, activityId, duration);
//        } else throw unauthorized();
//    }
    //
    @Override
    public Exercise getExerciseById(long id) {
        if (authorizationService.isSystem()) {
            logger.debug("Getting exercise " + id);
            var entity =  exerciseRepository.findById(id).orElseThrow(() ->
                    new NotFoundException("Exercise " + id + " not found")
            );
            return toExercise(entity);
        } else throw unauthorized();
    }

    @Override
    public Exercise createExercise(NewExercise exercise) {
        if (authorizationService.isSystem()) {
            logger.debug("Creating new exercise: " + exercise);
            var entity = exerciseRepository.save(fromExercise(exercise));
            return toExercise(entity);
        } else throw unauthorized();
    }


    @Override
    public Exercise updateExercise(Exercise exercise) {
        if (authorizationService.isSystem()) {
            logger.debug("Updating exercise: "+ exercise);
            var entity = exerciseRepository.save(fromExercise(exercise));
            return toExercise(entity);
        } else throw unauthorized();
    }

    @Override
    public void deleteExercise(long id) {
        if (authorizationService.isSystem()) {
            logger.debug("Deleting exercise " + id);
            exerciseRepository.delete(exerciseRepository.getReferenceById(id));
        } else throw unauthorized();
    }

    private AuthorizationException unauthorized() {
        var authorizationException = new AuthorizationException("Exercise is not authorized for this operation.");
        logger.error(authorizationException.getMessage());
        return authorizationException;
    }

    public static Exercise toExercise(ExerciseEntity entity) {
        return new Exercise(entity.getId(), entity.getUserId(), entity.getActivityId(), entity.getStartTime(), entity.getDuration(), entity.getKcalBurned());
    }

    public static ExerciseEntity fromExercise(Exercise exercise){
        ExerciseEntity entity = new ExerciseEntity();
        entity.setId(exercise.id());
        entity.setUserId(exercise.userId());
        entity.setActivityId(exercise.activityId());
        entity.setStartTime(exercise.startTime());
        entity.setDuration(exercise.duration());
        entity.setKcalBurned(exercise.kcalBurned());

        return entity;
    }

    public static ExerciseEntity fromExercise(NewExercise exercise){
        ExerciseEntity entity = new ExerciseEntity();
        entity.setUserId(exercise.userId());
        entity.setActivityId(exercise.activityId());
        entity.setStartTime(exercise.startTime());
        entity.setDuration(exercise.duration());

        return entity;
    }
}
