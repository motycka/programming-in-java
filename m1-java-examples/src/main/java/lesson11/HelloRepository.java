package lesson11;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
    protected final JdbcTemplate jdbcTemplate;

    public HelloRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String selectHelloInLanguage(String locale) {
        return jdbcTemplate.queryForObject(
                "SELECT message_value FROM i18n WHERE locale = ? AND message_key = 'hello' LIMIT 1",
                new Object[]{locale},
                String.class
        );
    }

}
