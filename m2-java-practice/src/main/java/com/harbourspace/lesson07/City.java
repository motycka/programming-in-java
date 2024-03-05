package com.harbourspace.lesson07;

public record City(
        String name,
        String country,
        long population
) {

    public String getCountry() {
        return country.toUpperCase();
    }

    public long getPopulation(Object o) {
        return population;
    }
}
