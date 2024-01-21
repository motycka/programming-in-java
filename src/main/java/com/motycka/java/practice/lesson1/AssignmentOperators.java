package com.motycka.java.practice.lesson1;

import java.util.Date;

public class AssignmentOperators {

    public static void main(String[] args) {

        String bigCity = "Bangkok";
        String capitalOf = "Thailand";
        boolean isCapital = true;
        int establishedYear = 1782;
        long population = 8280925L;
        double areaKm2 = 1568.0;

        System.out.println(bigCity + " is capital city of " + capitalOf);

        int yearToday = 2023;
        int cityAge = yearToday - establishedYear;
        System.out.println(bigCity + " is " + cityAge + " years old");

        double populationDensity = population / areaKm2;
        System.out.println(bigCity + " population density is " + populationDensity + "people/km2");

    }

}
