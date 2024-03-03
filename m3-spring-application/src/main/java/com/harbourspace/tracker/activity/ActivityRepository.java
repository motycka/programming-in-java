package com.harbourspace.tracker.activity;

import com.harbourspace.tracker.activity.model.Activity;
import com.harbourspace.tracker.activity.model.ActivityType;
import com.harbourspace.tracker.activity.model.NewActivity;
import com.harbourspace.tracker.config.ApplicationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ActivityRepository {

    private final Logger logger = LoggerFactory.getLogger(ActivityRepository.class);

    protected final JdbcTemplate jdbcTemplate;

    public ActivityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Activity> selectActivities(long userId) {
        return jdbcTemplate.query(
                "SELECT * FROM activity WHERE user_id in (?, ?)",
                this::rowMapper,
                userId,
                ApplicationConfiguration.SYSTEM_USER_ID
        );
    }


    Activity selectActivityById(long userId, long id) {
        return jdbcTemplate.query(
                "SELECT * FROM activity WHERE user_id in (?, ?) AND id = ? LIMIT 1",
                this::rowMapper,
                userId,
                ApplicationConfiguration.SYSTEM_USER_ID,
                id
        ).stream().findFirst().orElse(null);
    }

    boolean existsByName(long userId, String name) {
        return jdbcTemplate.query(
                "SELECT * FROM activity WHERE user_id in (?, ?) AND name = ? LIMIT 1",
                this::rowMapper,
                userId,
                ApplicationConfiguration.SYSTEM_USER_ID,
                name
        ).stream().findFirst().isPresent();
    }

    @Transactional
    Activity insertActivity(NewActivity activity) {
        logger.info("Inserting activity: " + activity.name() + " for user: " + activity.userId());
        return jdbcTemplate.query(
//                returning("INSERT INTO activity (name, user_id, kcal_per_minute) VALUES (?, ?, ?)"),
//                "SELECT id, name, user_id, kcal_per_minute FROM FINAL TABLE (\" + sql + \")",
                "INSERT INTO activity (name, user_id, kcal_per_minute) VALUES (?, ?, ?) RETURNING *",
                this::rowMapper,
                activity.name(),
                activity.userId(),
                activity.kcalPerMinute()
        ).stream().findFirst().orElse(null);
    }

    @Transactional
    Activity updateActivity(long userId, Activity activity) {
        logger.info("Updating activity: " + activity.name() + " for user: " + activity.userId());
        jdbcTemplate.update(
                "UPDATE activity SET name = ?, kcal_per_minute = ? WHERE user_id in (?, ?) AND id = ?",
                activity.name(),
                activity.kcalPerMinute(),
                userId,
                ApplicationConfiguration.SYSTEM_USER_ID,
                activity.id()
        );
        return selectActivityById(userId, activity.id());
    }

    @Transactional
    void deleteActivity(long userId, long id) {
        jdbcTemplate.update(
                "DELETE FROM activity WHERE user_id in (?, ?) AND id = ?",
                userId,
                ApplicationConfiguration.SYSTEM_USER_ID,
                id
        );
    }

    private Activity rowMapper(ResultSet rs, int i) throws SQLException {
        return new Activity(
                rs.getLong("id"),
                rs.getLong("user_id"),
                getActivityType(rs.getLong("user_id")),
                rs.getString("name"),
                rs.getDouble("kcal_per_minute")
        );
    }

    private ActivityType getActivityType(long userId) {
        if (userId == ApplicationConfiguration.SYSTEM_USER_ID) {
            return ActivityType.SYSTEM;
        } else {
            return ActivityType.USER;
        }
    }

}
