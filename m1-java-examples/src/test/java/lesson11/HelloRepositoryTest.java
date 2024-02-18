package lesson11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
//@Sql({"/i18n-schema.sql", "/i18n-test-data.sql"})
@Import(HelloRepository.class)
public class HelloRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HelloRepository helloRepository;

    @Test
    @DisplayName("Should return 'Hello' in English")
    public void testSelectHelloInLanguage() {
//        String result = new HelloRepository(jdbcTemplate).selectHelloInLanguage("en");
        String result = helloRepository.selectHelloInLanguage("en");
        assert result.equals("Hello");
    }


}
