package com.motycka.fit.user;

import com.motycka.fit.user.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    protected final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<User> selectAll() {
        return jdbcTemplate.query("SELECT * FROM users", this::rowMapper);
    }


    User selectById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ? LIMIT 1", this::rowMapper, id)
                .stream()
                .findFirst()
                .orElse(null);
    }

    User insert(User user, String token) {
        return jdbcTemplate.query(
                returning("INSERT INTO users (name, weight, date_of_birth, token) VALUES (?, ?, ?, ?)"),
                this::rowMapper,
                user.name(),
                user.weight(),
                user.dateOfBirth(),
                token
        ).stream().findFirst().orElse(null);
    }

    User update(User user) {
        return jdbcTemplate.query(
                returning("UPDATE users SET name = ?, weight = ?, date_of_birth = ? WHERE id = ?"),
                this::rowMapper,
                user.name(),
                user.weight(),
                user.dateOfBirth(),
                user.id()
        ).stream().findFirst().orElse(null);
    }

    void delete(Long id) {
        jdbcTemplate.query("DELETE FROM users WHERE id = ?", (rs, i) -> null, id);
    }

    private String returning(String sql) {
        return "SELECT id, name, weight, date_of_birth FROM FINAL TABLE (" + sql + ")";
    }

    private User rowMapper(ResultSet rs, int i) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("weight"),
                rs.getDate("date_of_birth").toLocalDate()
        );
    }
}
