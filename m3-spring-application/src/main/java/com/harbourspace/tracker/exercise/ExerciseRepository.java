package com.harbourspace.tracker.exercise;

import com.harbourspace.tracker.exercise.model.Exercise;
import com.harbourspace.tracker.exercise.model.NewExercise;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Repository
public class ExerciseRepository {

    protected final JdbcTemplate jdbcTemplate;

    public ExerciseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Exercise> selectAll(long userId) {
        return jdbcTemplate.query("SELECT * FROM exercise WHERE user_id = ?", this::rowMapper, userId);
    }

    Exercise selectById(long userId, long id) {
        return jdbcTemplate.query(
                "SELECT * FROM exercise WHERE id = ? AND user_id = ? LIMIT 1",
                        this::rowMapper,
                        id,
                        userId
                ).stream().findFirst().orElse(null);
    }

    Exercise insert(NewExercise exercise) {
        return jdbcTemplate.query(
                "SELECT * FROM FINAL TABLE (INSERT INTO exercise (user_id, activity_id, start_time, duration) VALUES (?, ?, ?, ?))",
                this::rowMapper,
                exercise.userId(),
                exercise.activityId(),
                Timestamp.from(exercise.startTime().withZoneSameInstant(ZoneOffset.UTC).toInstant()),
                exercise.duration()
        ).stream().findFirst().orElse(null);

    }

    Exercise update(long userId, Exercise exercise) {
        return jdbcTemplate.query(
                "SELECT * FROM FINAL TABLE (UPDATE exercise SET start_time = ?, duration = ? WHERE id = ? AND user_id = ?)",
                this::rowMapper,
                Timestamp.from(exercise.startTime().withZoneSameInstant(ZoneOffset.UTC).toInstant()),
                exercise.duration(),
                exercise.id(),
                userId
        ).stream().findFirst().orElse(null);
    }

    void delete(long userId, long id) {
        jdbcTemplate.update("DELETE FROM exercise WHERE id = ? AND user_id = ?", id, userId);
    }

    private Exercise rowMapper(ResultSet rs, int i) throws SQLException {
        return new Exercise(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("activity_id"),
                rs.getTimestamp("start_time").toInstant().atZone(ZoneOffset.UTC),
                rs.getDouble("duration"),
                null
        );
    }

}