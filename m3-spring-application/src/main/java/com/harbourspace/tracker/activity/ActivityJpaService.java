package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.error.AuthorizationException;
import com.harbourspace.tracker.error.NotFoundException;
import com.harbourspace.tracker.activity.model.NewActivity;
import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.exercise.ExerciseEntity;
import com.harbourspace.tracker.exercise.ExerciseJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Service
public class ActivityJpaService implements ActivityService {

    private final Logger logger = LoggerFactory.getLogger(ActivityJpaService.class);

    private final ActivityJpaRepository activityRepository;
    private final ExerciseJpaRepository exerciseRepository;
    private final AuthorizationService authorizationService;

    public ActivityJpaService(ActivityJpaRepository activityRepository, ExerciseJpaRepository exerciseRepository, AuthorizationService authorizationService){
        this.activityRepository = activityRepository;
        this.exerciseRepository = exerciseRepository;
        this.authorizationService = authorizationService;
    }

    @Override
    public List<Activity> getActivity() {
        if (authorizationService.isSystem()) {
            logger.debug("Getting all users");
            return activityRepository.findAll().stream().map(ActivityJpaService::toActivity).toList();
        } else throw unauthorized();
    }

    @Override
    public Activity getActivityById(long id) {
        if (authorizationService.isSystem()) {
            logger.debug("Getting activity " + id);
            var entity =  activityRepository.findById(id).orElseThrow(() ->
                    new NotFoundException("Activity " + id + " not found")
            );
            return toActivity(entity);
        } else throw unauthorized();
    }

    @Override
    public List<Activity> getActivityByUserId(long userId) {
        if (authorizationService.isSystem()) {
            logger.debug("Getting activities for userId " + userId);
            List<ActivityEntity> entities = activityRepository.findByUserId(userId);
            return entities.stream().map(ActivityJpaService::toActivity).collect(Collectors.toList());
        } else throw unauthorized();
    }

    @Override
    public Activity getActivityByName(String name){
        if (authorizationService.isSystem()) {
            logger.debug("Getting activity " + name);
            var entity =  activityRepository.findByName(name).orElseThrow(() ->
                    new NotFoundException("Activity " + name + " not found")
            );
            return toActivity(entity);
        } else throw unauthorized();
    }

    @Override
    public List<Activity> getActivitiesByType(String type) {
        if (authorizationService.isSystem()) {
            logger.debug("Getting activities for " + type);
            List<ActivityEntity> entities;
            if("SYSTEM".equalsIgnoreCase(type)){
                entities = activityRepository.findByUserId(0L);
            }
            else{
                entities = activityRepository.findByUserIdNot(0L);
            }

            return entities.stream().map(ActivityJpaService::toActivity).collect(Collectors.toList());
        } else throw unauthorized();
    }


    @Override
    public Activity createActivity(NewActivity newActivity) {
        if (authorizationService.isSystem()) {
            // Check if an activity with the same name for the user already exists
            Optional<ActivityEntity> existingActivity = activityRepository.findByUserIdAndName(newActivity.getUserId(), newActivity.getName());
            if (existingActivity.isPresent()) {
                throw new IllegalStateException("Activity with the same name already exists for this user.");
            }

            ActivityEntity entity = fromActivity(newActivity);
            ActivityEntity savedEntity = activityRepository.save(entity);
            return toActivity(savedEntity);
        } else {
            throw unauthorized();
        }
    }

    @Override
    public Activity updateActivity(long id, Activity activityUpdate) {
        if (!authorizationService.isSystem()) {
            throw unauthorized();
        }

        ActivityEntity existingActivity = activityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Activity with id " + id + " not found"));

        // Ensure updates do not change userId
        if (!existingActivity.getUserId().equals(activityUpdate.userId())) {
            throw new IllegalStateException("Updating the userId of an activity is not allowed.");
        }

        // Check for duplicates within the same userId
        Optional<ActivityEntity> duplicateActivity = activityRepository.findByUserIdAndNameAndKcalPerMinute(
                existingActivity.getUserId(), activityUpdate.name(), activityUpdate.kcalPerMinute());

        if (duplicateActivity.isPresent() && duplicateActivity.get().getId() != id) {
            throw new IllegalStateException("An identical activity already exists for this user. No update will be performed.");
        }

        // Apply updates, excluding userId
        existingActivity.setName(activityUpdate.name());
        existingActivity.setKcalPerMinute(activityUpdate.kcalPerMinute());
        existingActivity.setType(activityUpdate.type());

        ActivityEntity updatedEntity = activityRepository.save(existingActivity);
        return toActivity(updatedEntity);
    }

    @Override
    public Activity updateActivity(Long id, Activity activityUpdateRequest) {
        if (!authorizationService.isSystem()) {
            throw unauthorized();
        }

        // Find the existing activity
        ActivityEntity existingActivity = activityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Activity not found with id: " + id));

        if (!existingActivity.getUserId().equals(activityUpdateRequest.getUserId())) {
            throw new IllegalArgumentException("Updating userId is not allowed.");
        }

        // Update fields except userId
        existingActivity.setName(activityUpdateRequest.getName());
        existingActivity.setKcalPerMinute(activityUpdateRequest.getKcalPerMinute());

        ActivityEntity updatedActivity = activityRepository.save(existingActivity);

        return toActivity(updatedActivity); // Convert the entity back to the DTO/model
    }




    @Override
    public void deleteActivity(long id) {
        if (!authorizationService.isSystem()) {
            throw unauthorized();
        }

        ActivityEntity activityEntity = activityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Activity type not found."));

        if (activityEntity.getUserId() == 0) {
            throw new IllegalStateException("SYSTEM activity types cannot be deleted.");
        }

        // Check if the activity is in use by any exercise
        List<ExerciseEntity> exercisesUsingActivity = exerciseRepository.findByActivityId(id);
        if (!exercisesUsingActivity.isEmpty()) {
            throw new IllegalStateException("Activity cannot be deleted because it is in use.");
        }

        activityRepository.delete(activityEntity);
    }



    private AuthorizationException unauthorized() {
        var authorizationException = new AuthorizationException("User is not authorized for this operation.");
        logger.error(authorizationException.getMessage());
        return authorizationException;
    }


    public static ActivityEntity fromActivity(Activity activity) {
        ActivityEntity entity = new ActivityEntity();
        entity.setId(activity.id());
        entity.setUserId(activity.userId());
        entity.setName(activity.name());
        entity.setType(activity.type());
        entity.setKcalPerMinute(activity.kcalPerMinute());
        return entity;
    }

    public static ActivityEntity fromActivity(NewActivity activity) {
        ActivityEntity entity = new ActivityEntity();
        entity.setUserId(activity.userId());
        entity.setName(activity.name());
        entity.setType(activity.type());
        entity.setKcalPerMinute(activity.kcalPerMinute());
        return entity;
    }


    public static Activity toActivity(ActivityEntity entity) {
        String type = entity.getUserId() == 0 ? "SYSTEM" : "USER";
        return new Activity(entity.getId(), entity.getUserId(), entity.getName(), type, entity.getKcalPerMinute());
    }
}
