package com.harbourspace.tracker.activity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActivityJpaRepository extends JpaRepository<ActivityEntity, Long> {
    Optional<ActivityEntity> findByName(String name);

//    List<ActivityEntity> findByType(String type);

    List<ActivityEntity> findByUserId(Long userId);

    List<ActivityEntity> findByUserIdNot(Long userId);

    Optional<ActivityEntity> findByUserIdAndName(Long userId, String name);


    Optional<ActivityEntity> findByUserIdAndNameAndKcalPerMinute(Long userId, String name, Double kcalPerMinute);



}
