package lesson11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloServiceTest {

    @MockBean
    private HelloRepository helloRepository;

    @Autowired
    private HelloService helloService;

    @Test
    @DisplayName("should return localized hello")
    public void testHelloService() {
        Mockito.when(helloRepository.selectHelloInLanguage("en")).thenReturn("Hello");

        String result = helloService.sayHello("Monika", "en");
        assertEquals("Hello Monika!", result);

        Mockito.verify(helloRepository).selectHelloInLanguage("en");
    }

}
