package com.harbourspace.tracker.activity.jpa;

import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.error.AuthorizationException;
import com.harbourspace.tracker.error.NotFoundException;
import com.harbourspace.tracker.activity.ActivityService;
import com.harbourspace.tracker.activity.model.NewActivity;
import com.harbourspace.tracker.activity.model.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Primary
@Service
public class ActivityJpaService implements ActivityService{

    private final Logger logger = LoggerFactory.getLogger(ActivityJpaService.class);

    private final ActivityJpaRepository activityRepository;
    private final AuthorizationService authorizationService;

    private ActivityJpaService(ActivityJpaRepository activityRepository, AuthorizationService authorizationService){
        this.activityRepository = activityRepository;
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
    public Activity getActivityByUserId(long user_id) {
        if (authorizationService.isSystem()) {
            logger.debug("Getting activity " + user_id);
            var entity =  activityRepository.findById(user_id).orElseThrow(() ->
                    new NotFoundException("Activity " + user_id + " not found")
            );
            return toActivity(entity);
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
    public Activity createActivity(NewActivity activity){
        if (authorizationService.isSystem()) {
            logger.debug("Creating new activity: " + activity);
            var entity = activityRepository.save(fromActivity(activity));
            return toActivity(entity);
        } else throw unauthorized();
    }

    @Override
    public Activity updateActivity(Activity activity){
        if (authorizationService.isSystem()){
            logger.debug("Updating activity: " + activity);
            var entity = activityRepository.save(fromActivity(activity));
            return toActivity(entity);
        } else throw unauthorized();
    }

    @Override
    public void deleteActivity(long id){
        if (authorizationService.isSystem()){
            logger.debug("Deleting activity " + id);
            activityRepository.delete(activityRepository.getReferenceById(id));
        } else throw unauthorized();
    }

    private AuthorizationException unauthorized() {
        var authorizationException = new AuthorizationException("User is not authorized for this operation.");
        logger.error(authorizationException.getMessage());
        return authorizationException;
    }


    public static ActivityEntity fromActivity(Activity activity) {
        ActivityEntity entity = new ActivityEntity();
        entity.setId(activity.id());
        entity.setUser_id(activity.user_id());
        entity.setName(activity.name());
        entity.setKcal_per_minute(activity.kcal_per_minute());
        return entity;
    }

    public static ActivityEntity fromActivity(NewActivity activity) {
        ActivityEntity entity = new ActivityEntity();
        entity.setUser_id(activity.user_id());
        entity.setName(activity.name());
        entity.setKcal_per_minute(activity.kcal_per_minute());
        return entity;
    }


    public static Activity toActivity(ActivityEntity entity) {
        return new Activity(entity.getId(), entity.getUser_id(), entity.getName(), entity.getKcal_per_minute());
    }
}
