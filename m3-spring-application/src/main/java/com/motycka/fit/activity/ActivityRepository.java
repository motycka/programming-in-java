package com.motycka.fit.activity;

import com.motycka.fit.activity.model.ActivityType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityRepository {

    long counter = 1L;
    private List<ActivityType> activities = new ArrayList<>(List.of(
            new ActivityType(counter++, "Walking", 100.0),
            new ActivityType(counter++, "Running", 100.0),
            new ActivityType(counter++, "Cycling", 100.0),
            new ActivityType(counter++, "Muay Thai", 100.0),
            new ActivityType(counter++, "Motocross", 100.0),
            new ActivityType(counter++, "Swimming", 100.0)
    ));

    List<ActivityType> selectActivities() {
        return activities;
    }

    ActivityType selectActivityById(Long id) {
        return activities.stream().filter(a -> a.id().equals(id)).findFirst().orElse(null);
    }

    ActivityType insertActivity(ActivityType activityType) {
        ActivityType newActivityType = activityType.copy(counter++);
        activities.add(newActivityType);
        return newActivityType;
    }

    ActivityType updateActivity(ActivityType activityType) {
        activities = activities.stream().map(a -> a.id().equals(activityType.id()) ? activityType : a).toList();
        return activityType;
    }

    void deleteActivity(Long id) {
        activities = activities.stream().filter(a -> !a.id().equals(id)).toList();
    }
}
