package com.motycka.java.practice.lesson6;

/*
Design a class that holds information about each city
think about what data types to best use

think about the data class design

implement functionality, that will allow comparing populations of two cities

Comparable<WorldCity>
 */

public class WorldCity implements Comparable<WorldCity> {
    private final String name;
    private final String country;
    private final double latitude;
    private final double longitude;
    private final String iso2;
    private final String iso3;
    private final CapitalType cityType;
    private final long population;

    public WorldCity(String name, String country, double latitude, double longitude, String iso2, String iso3, CapitalType cityType, long population) {
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.cityType = cityType;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIso2() {
        return iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public CapitalType getCapital() {
        return cityType;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public int compareTo(WorldCity other) {
        return Long.compare(other.population, this.population);
    }
}
