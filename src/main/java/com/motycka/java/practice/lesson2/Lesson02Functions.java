package com.motycka.java.practice.lesson2;

public class Lesson02Functions {

    static int yearNow = 2024;


    public static void main(String[] args) {

        String cityName = "Bangkok";
        String countryName = "Thailand";
        boolean isCapital = true;
        short yearEstablished = 1782;
        int population = 8280925;
        float areaKm2 = 1568.0f;
        long countryPopulation = 71841779L;

        /*
        Take your work form lesson 1
        Create a function for each type of information you want to know about a city
         */


    }

    static void doSomething() {

    }

    static void printCityStatistics(String cityName, String countryName, int yearEstablished, long cityPopulation ,long countryPopulation, double cityAreaKm2) {

        int cityAge = yearNow - yearEstablished;
        double populationDensityKm2 = cityPopulation / cityAreaKm2;
        double cityAreaInM2 = cityAreaKm2 * 1000.0;
        double populationDensityM2 = populationDensityKm2 / cityAreaKm2;
        double percentOfCountryPopulation = cityPopulation / (countryPopulation / 100.0);


        System.out.println(cityName + " city is " + cityAge + " years old");
        System.out.println(cityName + " area is " + cityAreaKm2 + " km2 (" + cityAreaInM2 + " m2)");
        System.out.println(cityName + " has population density od " + populationDensityKm2 + " person/km2 (" + populationDensityM2 + " person/m2)");
        System.out.println(cityName + " makes " + percentOfCountryPopulation + "% " + countryName + " population");
    }

    static int getCityAge(int yearEstablished) {
        return yearNow - yearEstablished;
    }

    static double getPopulationDensity(long population, double areaKm2) {
        return population / areaKm2;
    }

//    static double countSomething() {
//
//    }

}
