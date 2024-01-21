package com.motycka.java.practice.lesson4;

import com.motycka.java.practice.lesson6.WorldCity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

interface IWorldCity {
    void load();

    List<WorldCity> getTopWorldCities(List<WorldCity> cities, int size);

    List<WorldCity> getTopCountryCities(List<WorldCity> cities, String country, int size);

    Map<String, List<WorldCity>> getCitiesByCountry(List<WorldCity> cities);

    LinkedHashMap<String, Integer> getCountriesByNumberOfCities(List<WorldCity> cities);
//    Map<String, Long> getCountriesByCityPopulationSize(List<WorldCity> cities);
}
