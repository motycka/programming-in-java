package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.model.NewActivity;
import com.harbourspace.tracker.activity.model.Activity;
import java.util.List;

public interface ActivityService {
    List<Activity> getActivity();

    Activity getActivityById(long id);

    List<Activity> getActivityByUserId(long user_id);

    List<Activity> getActivitiesByType(String type);

    Activity getActivityByName(String name);

    Activity createActivity(NewActivity activity);

//    Activity updateActivity(Activity activity);

    Activity updateActivity(long id, Activity activity);

    Activity updateActivity(Long id, Activity activity);

    void deleteActivity(long id);

}
