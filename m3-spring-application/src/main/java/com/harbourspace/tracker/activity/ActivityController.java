package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.NewActivity;
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
    List<Activity> getActivityTypes() {
        return activityService.getActivities();
    }

    @GetMapping("{id}")
    Activity getActivityType(@PathVariable(value = "id") Long id) {
        return activityService.getActivityById(id);
    }

    @PostMapping
    Activity createActivityType(@RequestBody NewActivity activity) {
        return activityService.createActivity(activity);
    }

    @PutMapping
    Activity updateActivityType(@RequestBody Activity activity) {
        return activityService.updateActivity(activity);
    }

    @DeleteMapping("{id}")
    void deleteActivityType(@PathVariable(value = "id") Long id) {
        activityService.deleteActivity(id);
    }

}
