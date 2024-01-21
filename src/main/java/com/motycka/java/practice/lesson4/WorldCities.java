package com.motycka.java.practice.lesson4;

import com.motycka.java.practice.lesson6.CapitalType;
import com.motycka.java.practice.lesson6.WorldCity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

// TODO create a stic loader and then an instance to demonstrate problems during testing
public class WorldCities {

    private List<WorldCity> cities = new ArrayList<>();

    public WorldCities load(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            cities = reader.lines()
                    .skip(1) // first line is header, skip
                    .map(line -> {
                        String[] columns = line.split("\\|");
                        return new WorldCity(
                                columns[1],
                                columns[4],
                                Double.parseDouble(columns[2]),
                                Double.parseDouble(columns[3]),
                                columns[5],
                                columns[6],
                                getCityType(columns[8]),
                                columns[9].isBlank() ? 0 : (long) Double.parseDouble(columns[9]) // TODO this is example of downcasting
                        );
                    }).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    public List<WorldCity> getTopWorldCities(int size) {
        return cities.stream().sorted().limit(size).toList();
    }

    public List<WorldCity> getTopCountryCities(String country, int size) {
        // TODO handle country not found
        // TODO handle less than size cities
        return cities.stream()
                .filter(city -> city.getCountry().equals(country))
                .sorted()
                .limit(size)
                .toList();
    }

    public Map<String, List<WorldCity>> getCitiesByCountry() {
        return cities.stream().collect(groupingBy(WorldCity::getCountry));
    }

    public LinkedHashMap<String, Integer> getCountriesByNumberOfCities() {
        return getCitiesByCountry()
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

    public Map<String, Long> getCountriesByCityPopulation() {
        return cities.stream()
                .collect(
                        groupingBy(
                                WorldCity::getCountry,
                                Collectors.summingLong(WorldCity::getPopulation)
                        )
                );
    }

    private CapitalType getCityType(String type) {
        return switch (type) {
            case "primary" -> CapitalType.PRIMARY;
            case "admin" -> CapitalType.ADMIN;
            case "minor" -> CapitalType.MINOR;
            default -> CapitalType.NONE;
        };
    }
}
