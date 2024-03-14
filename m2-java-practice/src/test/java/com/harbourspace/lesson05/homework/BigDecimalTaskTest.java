package com.harbourspace.lesson05.homework;

import com.harbourspace.lesson06.BigDecimalTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTaskTest {

    @Test
    public void testCalculateAreaOfCircleWithValidInput() {
        BigDecimal radius = new BigDecimal("4.5");
        int decimalPlaces = 2;
        BigDecimal expected = new BigDecimal("63.62"); // Approximate area with radius 4.5
        BigDecimal result = BigDecimalTask.calculateAreaOfCircle(radius, decimalPlaces);
        Assertions.assertEquals(0, expected.compareTo(result), "The calculated area should match the expected result.");
    }

    @Test
    public void testCalculateAreaOfCircleWithZeroRadius() {
        BigDecimal radius = BigDecimal.ZERO;
        int decimalPlaces = 2;
        Assertions.assertThrows(IllegalArgumentException.class, () -> BigDecimalTask.calculateAreaOfCircle(radius, decimalPlaces), "Radius must be positive");
    }

    @Test
    public void testCalculateAreaOfCircleWithNegativeRadius() {
        BigDecimal radius = new BigDecimal("-1");
        int decimalPlaces = 2;
        Assertions.assertThrows(IllegalArgumentException.class, () -> BigDecimalTask.calculateAreaOfCircle(radius, decimalPlaces), "Radius must be positive");
    }

    @Test
    public void testCalculateAreaOfCircleWithNegativeDecimalPlaces() {
        BigDecimal radius = new BigDecimal("5");
        int decimalPlaces = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> BigDecimalTask.calculateAreaOfCircle(radius, decimalPlaces), "Decimal places must be non-negative");
    }

    @Test
    public void testCalculateAreaOfCircleWithHighPrecision() {
        BigDecimal radius = new BigDecimal("2");
        int decimalPlaces = 10;
        BigDecimal expected = new BigDecimal("12.5663706144"); // Approximate area with radius 2
        BigDecimal result = BigDecimalTask.calculateAreaOfCircle(radius, decimalPlaces);
        Assertions.assertEquals(0, expected.compareTo(result), "The calculated area should match the expected result with high precision.");
    }
}
