package com.harbourspace.lesson07;

/*
Design a class that holds information about each city
think about what data types to best use

think about the data class design

implement functionality, that will allow comparing populations of two cities

Comparable<WorldCity>
 */

public class City implements Comparable<City> {
    private final String name;
    private final String country;
    private final long population;

    public City(String name, String country, long population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public int compareTo(City other) {
        return Long.compare(other.population, this.population);
    }
}
