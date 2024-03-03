package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.NewActivity;
import com.harbourspace.tracker.error.AuthorizationException;
import com.harbourspace.tracker.authorization.AuthorizationService;
import com.harbourspace.tracker.error.ConflictException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final AuthorizationService authorizationService;

    public ActivityService(ActivityRepository activityRepository, AuthorizationService authorizationService) {
        this.activityRepository = activityRepository;
        this.authorizationService = authorizationService;
    }

    public List<Activity> getActivities() {
        return activityRepository.selectActivities(getCurrentUserId());
    }

    public Activity getActivityById(long id) {
        return activityRepository.selectActivityById(getCurrentUserId(), id);
    }

    public Activity createActivity(NewActivity activity) {
        var userId = getCurrentUserId();

        if (activity.userId() != userId) {
            throw new AuthorizationException("User is not allowed to create activity for another user");
        }

        if (activityRepository.existsByName(userId, activity.name())) {
            throw new ConflictException("Activity with this name already exists");
        }

        return activityRepository.insertActivity(activity);
    }

    public Activity updateActivity(Activity activity) {
        if (!isPermitted(getCurrentUserId(), activity.id())) {
            throw new AuthorizationException("User is not allowed to update this activity");
        }
        return activityRepository.updateActivity(getCurrentUserId(), activity);
    }

    public void deleteActivity(Long id) {
        if (!isPermitted(getCurrentUserId(), id)) {
            throw new AuthorizationException("User is not allowed to delete this activity");
        }
        activityRepository.deleteActivity(getCurrentUserId(), id);
    }

    private long getCurrentUserId() {
        return authorizationService.getCurrentUser().id();
    }

    private boolean isPermitted(long userId, long activityId) {
        return activityRepository.selectActivityById(userId, activityId).userId() == userId;
    }
}
