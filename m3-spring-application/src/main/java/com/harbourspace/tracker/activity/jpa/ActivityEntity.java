package com.harbourspace.tracker.activity.jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "activity")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private String name;
    private Double kcal_per_minute;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getKcal_per_minute() {
        return kcal_per_minute;
    }

    public void setKcal_per_minute(Double kcal_per_minute) {
        this.kcal_per_minute = kcal_per_minute;
    }
}
