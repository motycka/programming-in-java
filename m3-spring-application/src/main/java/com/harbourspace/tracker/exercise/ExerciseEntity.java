package com.harbourspace.tracker.exercise;

import jakarta.persistence.*;

import java.util.Date;



@Entity
@Table(name = "exercise")
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "activity_id")
    private Long activityId;
    @Column(name = "start_time")
    private Date startTime;
    private Long duration;
    @Column(name = "kcalBurned")
    private Double kcalBurned;

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Double getKcalBurned() {
        return kcalBurned;
    }

    public void setKcalBurned(Double kcalBurned) {
        this.kcalBurned = kcalBurned;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getActivityId() {
        return activityId;
    }
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }



}
