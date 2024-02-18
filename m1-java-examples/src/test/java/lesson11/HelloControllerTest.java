package lesson11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @MockBean
    private HelloService helloService;

    @Autowired
    private MockMvc mockMvc;

    private final String path = "/api/hello";
    private final String name = "Monika";
    private final String locale = "es";
    private final String expected = "Hola Monika!";

    @BeforeEach
    void setUp() {
        Mockito.when(helloService.sayHello(name, locale)).thenReturn(expected);
    }

    @Test
    @DisplayName("GET /api/hello?name={name}&locale={locale} - should responds with 200")
    void testHelloController() throws Exception {
        mockMvc.perform(get(path + "?name=" + name + "&locale=" + locale))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    @DisplayName("GET /api/hello - should responds with 400")
    void testHelloControllerMissingParameters() throws Exception {
        mockMvc.perform(get(path))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
