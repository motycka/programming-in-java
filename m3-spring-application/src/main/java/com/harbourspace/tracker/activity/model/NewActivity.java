package com.harbourspace.tracker.activity.model;

import com.harbourspace.tracker.user.model.User;

public record NewActivity(
        Long user_id,
        String name,
        Double kcal_per_minute
) {
    public Activity toActivity(long id) {
        return new Activity(id, user_id, name, kcal_per_minute);
    }
}
