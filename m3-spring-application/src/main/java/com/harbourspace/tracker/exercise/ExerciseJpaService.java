package com.harbourspace.tracker.exercise;


import com.harbourspace.tracker.activity.ActivityEntity;
import com.harbourspace.tracker.activity.ActivityJpaRepository;
import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.error.AuthorizationException;
import com.harbourspace.tracker.error.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Service
public class ExerciseJpaService implements ExerciseService {

    private final Logger logger = LoggerFactory.getLogger(ExerciseJpaService.class);

    private final ExerciseJpaRepository exerciseRepository;

    private final ActivityJpaRepository activityRepository;
    private final AuthorizationService authorizationService;

    public ExerciseJpaService(ExerciseJpaRepository exerciseRepository, ActivityJpaRepository activityRepository, AuthorizationService authorizationService) {
        this.exerciseRepository = exerciseRepository;
        this.activityRepository = activityRepository;
        this.authorizationService = authorizationService;
    }
    @Override
    public List<Exercise> getExercises() {
        if (authorizationService.isSystem()) {
            logger.debug("Getting all exercises");
            return exerciseRepository.findAll().stream().map(ExerciseJpaService::toExercise).toList();
        } else throw unauthorized();
    }



    @Override
    public List<Exercise> getExerciseByFilter(Date filterDate, Long activityId, Long duration) {
        // Convert Date to LocalDate
        LocalDate localDate = filterDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calculate the start and end of the day for the provided date
        LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime startOfNextDay = localDate.plusDays(1).atStartOfDay();

        // Convert LocalDateTime back to Date
        Date startOfDayDate = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
        Date startOfNextDayDate = Date.from(startOfNextDay.atZone(ZoneId.systemDefault()).toInstant());


        List<ExerciseEntity> entities = exerciseRepository.findByDateRangeActivityIdAndDuration(startOfDayDate, startOfNextDayDate, activityId, duration);


        return entities.stream().map(ExerciseJpaService::toExercise).collect(Collectors.toList());
    }


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
    public List<Exercise> getExerciseByActivityId(long id) {
        if (authorizationService.isSystem()) {
            logger.debug("Getting all Exercise By ActivityId");
            return exerciseRepository.findByActivityId(id).stream().map(ExerciseJpaService::toExercise).toList();
        } else throw unauthorized();
    }


    @Override
    public Exercise createExercise(NewExercise exercise) {
        Long currentUserId = exercise.userId();
        if (currentUserId == null || !currentUserId.equals(exercise.userId())) {
            throw new AuthorizationException("User is not authorized or not authenticated.");
        }

        Optional<ActivityEntity> activityEntity = activityRepository.findById(exercise.activityId());
        if (!activityEntity.isPresent()) {
            throw new NotFoundException("Activity not found with ID: " + exercise.activityId());
        }

        // Calculate kcalBurned
        double kcalBurned = calculateKcalBurned(activityEntity.get().getKcalPerMinute(), exercise.duration().intValue());

        Optional<ExerciseEntity> existingExercise = exerciseRepository.findByUserIdAndActivityIdAndStartTime(
                exercise.userId(), exercise.activityId(), exercise.startTime());
        if (existingExercise.isPresent()) {
            throw new IllegalStateException("An exercise for this activity and start time already exists for this user.");
        }

        ExerciseEntity entity = fromExercise(exercise);
        entity.setKcalBurned(kcalBurned);
        ExerciseEntity savedEntity = exerciseRepository.save(entity);
        return toExercise(savedEntity);
    }

    private double calculateKcalBurned(double kcalPerMinute, int duration) {
        return kcalPerMinute * (duration / 60.0); // Duration in seconds, so divide by 60 to get minutes
    }



    @Override
    public Exercise updateExercise(Exercise exercise) {
        Long currentUserId = exercise.userId();
        var existingExercise = exerciseRepository.findById(exercise.id())
                .orElseThrow(() -> new NotFoundException("Exercise not found."));

        if (!existingExercise.getUserId().equals(currentUserId)) {
            throw new AuthorizationException("User is not authorized to update this exercise.");
        }

        ExerciseEntity entity = fromExercise(exercise);
        ExerciseEntity savedEntity = exerciseRepository.save(entity);
        return toExercise(savedEntity);
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
