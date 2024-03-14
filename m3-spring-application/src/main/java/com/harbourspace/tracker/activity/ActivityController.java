package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.NewActivity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/activity")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    ResponseEntity<List<Activity>>getActivity() {
        return ResponseEntity.ok(activityService.getActivity());
    }

    @GetMapping("{id}")
    ResponseEntity<Activity> getActivityById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(activityService.getActivityById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Activity>> getActivitiesByUserId(@PathVariable("userId") Long userId) {
        List<Activity> activitiesByUser = activityService.getActivityByUserId(userId);
        if (activitiesByUser.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(activitiesByUser);
    }

    @GetMapping("/type/{type}")
    ResponseEntity<List<Activity>> getActivitiesByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(activityService.getActivitiesByType(type));
    }

    @PostMapping
    ResponseEntity<Activity> createActivity(@RequestBody NewActivity activity) {
        return new ResponseEntity<>(activityService.createActivity(activity), HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable("id") Long id, @RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.updateActivity(id, activity));
    }


    @DeleteMapping("{id}")
    ResponseEntity<Object> deleteActivity(@PathVariable("id") Long id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok().build();
    }



}

