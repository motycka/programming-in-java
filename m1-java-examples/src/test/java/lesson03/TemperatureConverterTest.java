package lesson03;

import org.junit.jupiter.api.*;


public class TemperatureConverterTest {

    @BeforeAll
    public static void setUp() {
        System.out.println("This runs once before all tests");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("This runs before each test");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("This runs once after all tests");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("This runs after each test");
    }

    @Test
    @DisplayName("should convert Celsius to Fahrenheit - 0C = 32F")
    public void testConvertCelsiusToFahrenheit() {
        Assertions.assertEquals(32.0, TemperatureConverter.toFahrenheit(0.0));
    }

    @Test
    @DisplayName("should convert Fahrenheit to Celsius - 32F = 0C")
    public void testConvertFahrenheitToCelsius() {
        Assertions.assertEquals(0.0, TemperatureConverter.toCelsius(32.0));
    }

}
