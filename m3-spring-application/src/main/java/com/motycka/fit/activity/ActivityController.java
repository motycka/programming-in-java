package com.motycka.fit.activity;

import com.motycka.fit.activity.model.ActivityType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    List<ActivityType> getActivities() {
        return activityService.getActivities();
    }

    @GetMapping("{id}")
    ActivityType getActivities(
            @PathVariable(value = "id") Long id
    ) {
        return activityService.getActivityById(id);
    }

    @PostMapping
    ActivityType createActivity(
            @RequestBody ActivityType activityType
    ) {
        return activityService.createActivity(activityType);
    }

    @PutMapping
    ActivityType updateActivity(
            @RequestBody ActivityType activityType
    ) {
        return activityService.updateActivity(activityType);
    }

    @DeleteMapping("{id}")
    void deleteActivity(
            @PathVariable(value = "id") Long id
    ) {
        activityService.deleteActivity(id);
    }

}
