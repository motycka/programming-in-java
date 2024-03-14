package com.harbourspace.lesson06;

public class MathTask {

    public static double generateRandomNumber(double min, double max, int decimalPlaces) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("decimalPlaces must be non-negative");
        }

        double range = max - min;
        double scaled = (Math.random() * range) + min;
        double rounded = Math.round(scaled * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);

        return rounded;
    }
}

