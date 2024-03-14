package com.harbourspace.tracker.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseJpaRepository extends JpaRepository<ExerciseEntity, Long> {
    Optional<ExerciseEntity> findByName(String name);




}
