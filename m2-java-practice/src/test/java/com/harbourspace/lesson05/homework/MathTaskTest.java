package com.harbourspace.lesson05.homework;

import com.harbourspace.lesson06.MathTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathTaskTest {

    @Test
    public void testGenerateRandomNumber() {
        double min = 1.0;
        double max = 2.0;
        int decimalPlaces = 2;
        double randomNumber = MathTask.generateRandomNumber(min, max, decimalPlaces);

        Assertions.assertTrue(randomNumber >= min && randomNumber <= max, "Random number should be within bounds");

        String strNumber = Double.toString(randomNumber);
        int indexOfDecimal = strNumber.indexOf('.');
        int numberOfDecimalPlaces = strNumber.length() - indexOfDecimal - 1;

        Assertions.assertTrue(numberOfDecimalPlaces <= decimalPlaces, "Random number should have the correct number of decimal places");
    }

    @Test
    public void testInvalidRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MathTask.generateRandomNumber(5.0, 2.0, 2);
        });
    }

    @Test
    public void testNegativeDecimalPlaces() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MathTask.generateRandomNumber(1.0, 2.0, -1);
        });
    }
}
