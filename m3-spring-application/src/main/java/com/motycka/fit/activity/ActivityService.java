package com.motycka.fit.activity;

import com.motycka.fit.activity.model.ActivityType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityType> getActivities() {
        return activityRepository.selectActivities();
    }

    public ActivityType getActivityById(Long id) {
        return activityRepository.selectActivityById(id);
    }

    public ActivityType createActivity(ActivityType activityType) {
        return activityRepository.insertActivity(activityType);
    }

    public ActivityType updateActivity(ActivityType activityType) {
        return activityRepository.updateActivity(activityType);
    }

    public void deleteActivity(Long id) {
        activityRepository.deleteActivity(id);
    }
}
