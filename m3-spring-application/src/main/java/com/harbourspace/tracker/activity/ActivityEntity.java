package com.harbourspace.tracker.activity;

import jakarta.persistence.*;

@Entity
@Table(name = "activity")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userId")
    private Long userId;
    private String name;

    private String type;
    @Column(name = "kcalPerMinute")
    private Double kcalPerMinute;


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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getKcalPerMinute() {
        return kcalPerMinute;
    }

    public void setKcalPerMinute(Double kcalPerMinute) {
        this.kcalPerMinute = kcalPerMinute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
