package com.harbourspace.tracker.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ExerciseJpaRepository extends JpaRepository<ExerciseEntity, Long> {
    Optional<ExerciseEntity> findByUserIdAndActivityIdAndStartTime(Long userId, Long activityId, Date startTime);

    @Query("SELECT e FROM ExerciseEntity e WHERE e.startTime >= :startOfDay AND e.startTime < :startOfNextDay AND e.activityId = :activityId AND e.duration = :duration")
    List<ExerciseEntity> findByDateRangeActivityIdAndDuration(@Param("startOfDay") Date startOfDay, @Param("startOfNextDay") Date startOfNextDay, @Param("activityId") Long activityId, @Param("duration") Long duration);


    List<ExerciseEntity> findByActivityId(long id);
}
