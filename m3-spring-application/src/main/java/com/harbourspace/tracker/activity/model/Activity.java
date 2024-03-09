package com.harbourspace.tracker.activity.model;

public record Activity(
    Long id,
    Long user_id,
    String name,
    Double kcal_per_minute



) {
    public com.harbourspace.tracker.activity.model.Activity copyWithId(Long id) {
        return new com.harbourspace.tracker.activity.model.Activity(id, user_id, name, kcal_per_minute);
    }

}
