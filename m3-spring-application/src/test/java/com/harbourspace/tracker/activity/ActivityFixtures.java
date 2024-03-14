package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.model.NewActivity;
import com.harbourspace.tracker.activity.model.Activity;

import java.util.List;

public class ActivityFixtures {
    public static final Activity activity0 = new Activity(0L, 0L, "Walking", 5.0);
    public static final Activity activity1 = new Activity(1L, 0L, "Running", 10.0);
    public static final Activity activity2 = new Activity(2L, 0L, "Cycling", 8.0);
    public static final Activity activity3 = new Activity(3L, 0L, "Swimming", 7.0);
    public static final Activity activity4 = new Activity(4L, 0L, "Weight Training", 3.0);

    public static final List<Activity> activities = List.of(activity0, activity1, activity2, activity3, activity4);
    public static final NewActivity newActivity = new NewActivity(0L, "Jumping Jack", 50.0);
    public static final Activity activity5 = new Activity(3L, newActivity.userId(), newActivity.name(), newActivity.kcalPerMinute());
    public static  final Activity activity5Updated = new Activity(activity5.id(), activity5.userId(), "HIIT", activity5.kcalPerMinute());
}
