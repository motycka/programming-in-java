package lesson03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemperatureConverter {

    private static final Logger logger = LoggerFactory.getLogger(TemperatureConverter.class);

    /**
     * Converts temperature value given in Fahrenheit to Celsius
     *
     * @param fahrenheit temperature value in Fahrenheit
     * @return temperature value in Celsius
     * @see <a href="https://en.wikipedia.org/wiki/Fahrenheit">Fahrenheit</a>
     * @see <a href="https://en.wikipedia.org/wiki/Celsius">Celsius</a>
     */
    public static Double toCelsius(Double fahrenheit) {
        logger.info("Converting " + fahrenheit + " Fahrenheit to Celsius");
        return (fahrenheit - 32) * 5 / 9;
    }

    /**
     * Converts temperature value given in Celsius to Fahrenheit
     *
     * @param celsius temperature value in Celsius
     * @return temperature value in Fahrenheit
     * @see <a href="https://en.wikipedia.org/wiki/Fahrenheit">Fahrenheit</a>
     * @see <a href="https://en.wikipedia.org/wiki/Celsius">Celsius</a>
     */
    public static Double toFahrenheit(Double celsius) {
        logger.info("Converting " + celsius + " Celsius to Fahrenheit");
        return celsius * 9 / 5 + 32;
    }

}

