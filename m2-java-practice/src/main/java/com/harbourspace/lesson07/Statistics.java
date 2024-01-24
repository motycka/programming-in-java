package com.harbourspace.lesson07;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public interface Statistics {

    List<City> getTopWorldCities(int size);

    List<City> getTopCountryCities(String country, int size);

    Map<String, List<City>> getCitiesByCountry();

    LinkedHashMap<String, Integer> getCountriesByNumberOfCities();

    Map<String, Long> getCountriesByCityPopulationSize();

    /*
     show also functional programming

     worldCities.sortedByPopulation().topWorldCities();
     */


}
