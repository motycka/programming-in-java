package com.harbourspace.tracker.activity.model;

public record Activity(
    Long id,
    Long userId,
    String name,
    String type,

    Double kcalPerMinute



) {
    public com.harbourspace.tracker.activity.model.Activity copyWithId(Long id) {
        return new com.harbourspace.tracker.activity.model.Activity(id, userId, name, type, kcalPerMinute);
    }

    public Long getUserId() {
        return userId;
    }


    public String getName() {
        return name;
    }

    public Double getKcalPerMinute() {
        return kcalPerMinute;
    }

    public Long getId() {
        return id;
    }
}
