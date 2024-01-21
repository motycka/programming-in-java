package com.motycka.java.practice.lesson1;

/*
Before exercise, explain how to

assign values
cast
parentheses
System.out.println
string concatenation

 */
public class Lesson01MainExample {

    public static void main(String[] args) {

        /*
        Exercise 1

            In the `Lesson01Main` class, define variables that will hold information about the city of Bangkok:
                - City name
                - Country name
                - If it is a country's capital city
                - Year city was established
                - City cityPopulation
                - City area in m2
                - Country cityPopulation (of Thailand)
                - Country area in m2
         */
        String cityName = "Bangkok";
        String countryName = "Thailand";
        boolean isCapital = true;
        short yearEstablished = 1782;
        int cityPopulation = 8280925;
        float cityAreaKm2 = 1568.0f;
        long countryPopulation = 71841779L;

        /*
        Exercise 2

            Write code, that will do the following arithmetic operations and save each ot a new variable:
                1. Calculate city age in years
                2. Calculate city population density for km2
                3. Calculate city area in m2
                2. Calculate city population density for m2
                4. Calculate how much % of Thailand city population lives in Bangkok (as decimal number)

            Use `System.out.println(value);` to write results to console.

            Some of the result have very high number of decimal numbers. What could we do about it?

            Add
            ```
            cityAge++;
            System.out.println(cityAge);
            ```
            What happens and why?

            Run the program.
         */

        int cityAge = 2023 - yearEstablished;
        double populationDensityKm2 = cityPopulation / cityAreaKm2;
        double cityAreaInM2 = cityAreaKm2 * 1000.0;
        double populationDensityM2 = populationDensityKm2 / cityAreaKm2;
        double percentOfCountryPopulation = cityPopulation / (countryPopulation / 100.0);

        System.out.println(cityName + " city is " + cityAge + " years old");
        System.out.println(cityName + " area is " + cityAreaKm2 + " km2 (" + cityAreaInM2 + " m2)");
        System.out.println(cityName + " has cityPopulation density od " + populationDensityKm2 + " person/km2 (" + populationDensityM2 + " person/m2)");
        System.out.println(cityName + " makes " + percentOfCountryPopulation + "% " + countryName + " cityPopulation");

        /*

        Conditionals

         */

        if (isCapital) {
            System.out.println(cityName + " is capital of " + countryName);
        } else {
            System.out.println(cityName + " is not capital of " + countryName);
        }


        if (cityAge <= 100) {
            System.out.println(cityName + " is a new, modern city");
        } else if (cityAge <= 200) {
            System.out.println(cityName + " is more than 100 years old");
        } else if (cityAge <= 300) {
            System.out.println(cityName + " is more than 200 years old");
        } else {
            System.out.println(cityName + " is more than 300 years old");
        }
    }
}
