package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.model.NewActivity;
import com.harbourspace.tracker.activity.model.Activity;

import java.util.List;

public class ActivityFixtures {
    public static final Activity activity0 = new Activity(1L, 0L, "Walking", "SYSTEM",5.0);
    public static final Activity activity1 = new Activity(2L, 0L, "Running", "SYSTEM",10.0);
    public static final Activity activity2 = new Activity(3L, 0L, "Cycling", "SYSTEM",8.0);
    public static final Activity activity3 = new Activity(4L, 0L, "Swimming", "SYSTEM",7.0);
    public static final Activity activity4 = new Activity(5L, 0L, "Weight Training", "SYSTEM",3.0);

    public static final Activity activity5 = new Activity(6L, 1L, "Eating", "USER",5.0);
    public static final Activity activity6 = new Activity(7L, 2L, "Crying", "USER",10.0);


    public static final List<Activity> activities = List.of(activity0, activity1, activity2, activity3, activity4, activity5, activity6);
    public static final NewActivity newActivity = new NewActivity(1L, "Jumping Jack", "USER",50.0);
    public static final Activity activity7 = new Activity(9L, newActivity.userId(), newActivity.name(), newActivity.type(),newActivity.kcalPerMinute());
    public static  final Activity activity7Updated = new Activity(3L, 0L, "Working", "SYSTEM", 10.0);
}
