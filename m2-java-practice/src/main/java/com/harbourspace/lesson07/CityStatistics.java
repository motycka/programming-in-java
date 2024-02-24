package com.harbourspace.lesson07;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CityStatistics implements Statistics {

    private final List<City> cities;

    public CityStatistics(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public List<City> getTopWorldCities(int size) {
        return cities.stream()
                .sorted()
                .limit(size)
                .toList();
    }

    @Override
    public List<City> getTopCountryCities(String country, int size) {
        // TODO handle country not found
        // TODO handle less than size cities
        return cities.stream()
                .filter(city -> city.getCountry().equals(country))
                .sorted()
                .limit(size)
                .toList();
    }

    @Override
    public Map<String, List<City>> getCitiesByCountry() {
        return cities.stream().collect(groupingBy(City::getCountry));
    }

    @Override
    public LinkedHashMap<String, Integer> getCountriesByNumberOfCities() {
        return this.getCitiesByCountry()
                .entrySet()
                .stream()
                .map( entry -> Map.entry(entry.getKey(), entry.getValue().size()))
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,     // function to get key
                                Map.Entry::getValue,   // function to get value
                                (v1, v2) -> v2,        // merge function in case of duplicate keys
                                LinkedHashMap::new     // supplier of the map
                        )
                );
    }

    @Override
    public Map<String, Long> getCountriesByCityPopulationSize() {
        return cities.stream().collect(
                groupingBy(
                        City::getCountry,
                        Collectors.summingLong(City::getPopulation)
                )
        );
    }
}
