package com.harbourspace.lesson06;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTask {

    public static BigDecimal calculateAreaOfCircle(BigDecimal radius, int decimalPlaces) {
        // Check for valid input
        if (radius.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("Decimal places must be non-negative");
        }

        // Define a MathContext for the desired precision, which is decimalPlaces + a few extra digits for intermediate calculations
        MathContext mc = new MathContext(decimalPlaces + 5, RoundingMode.HALF_UP);

        // Pi is approximated to a precision of decimalPlaces + 5 to ensure accuracy in the final result
        BigDecimal pi = new BigDecimal("3.14159265358979323846").round(mc);

        // Calculate the area (π * radius^2)
        BigDecimal area = radius.pow(2, mc).multiply(pi, mc);

        // Round the result to the specified number of decimal places
        return area.setScale(decimalPlaces, RoundingMode.HALF_UP);
    }

    // Add a main method if you want to run a quick test
    public static void main(String[] args) {
        BigDecimal radius = new BigDecimal("3.5");
        int decimalPlaces = 2;
        BigDecimal area = calculateAreaOfCircle(radius, decimalPlaces);
        System.out.println("Area of the circle: " + area);
    }
}

