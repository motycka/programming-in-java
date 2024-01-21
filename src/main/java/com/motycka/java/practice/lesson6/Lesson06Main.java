package com.motycka.java.practice.lesson6;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/*
Parse cities
sort them by size, write 10 biggest cities
group them by country, write 5 biggest by country


 */
public class Lesson06Main {

    private static final String filePath = "/Users/monikaprotivova/IdeaProjects/Playground/java-programming-course/src/main/resources/worldcities.csv";

    public static void main(String[] args) {
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            List<WorldCity> cities = reader.lines()
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
                                columns[9].isBlank() ? 0 : (long) Double.parseDouble(columns[9]) // TODO downcasting
                        );
                    }).toList();

//            printAsRankedList("To 10 world cities by population:", getTopWorldCities(cities, 10));
//
//            printAsRankedList("Top 10 Thai cities by population:", getTopCountryCities(cities, "Thailand", 5));
//
//            printAsRankedList("Top 10 Czech cities by population:", getTopCountryCities(cities, "Czechia", 5));
//

            System.out.println("Countries by number of cities:");
            getCountriesByNumberOfCities(cities)
                    .forEach((country, numberOfCities) -> {
                        System.out.println(country + " - " + numberOfCities);
                    });

            // Top 5 cities from top 5 countries

            // TODO extract to methods, we will be testing this

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<WorldCity> getTopWorldCities(List<WorldCity> cities, int size) {
        return cities.stream()
                .sorted()
                .limit(size)
                .toList();
    }

    private static List<WorldCity> getTopCountryCities(List<WorldCity> cities, String country, int size) {
        // TODO handle country not found
        // TODO handle less than size cities
        return cities.stream()
                .filter(city -> city.getCountry().equals(country))
                .sorted()
                .limit(size)
                .toList();
    }

    private static Map<String, List<WorldCity>> getCitiesByCountry(List<WorldCity> cities) {
        return cities.stream().collect(groupingBy(WorldCity::getCountry));
    }


    private static LinkedHashMap<String, Integer> getCountriesByNumberOfCities(List<WorldCity> cities) {
        return getCitiesByCountry(cities)
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

    private static Map<String, Long> getCountriesByCityPopulationSize(List<WorldCity> cities) {
        return cities.stream()
                .collect(
                        groupingBy(
                                WorldCity::getCountry,
                                Collectors.summingLong(WorldCity::getPopulation)
                        )
                );
    }


    /*
     show also functional programming

     worldCities.sortedByPopulation().topWorldCities();
     */

    private static void printAsRankedList(String header, List<WorldCity> cities) {
        AtomicInteger rank = new AtomicInteger(1); // TODO explain
        printHeader(header);
        cities.forEach(city -> {
            printRank(rank, city.getName(), city.getPopulation()); // TODO format
            rank.getAndIncrement();
        });
    }

    public static void printAsRankedList(String header, Map<String, Long> cities) {
        AtomicInteger rank = new AtomicInteger(1);
        printHeader(header);
        cities.forEach((country, number) -> {
            printRank(rank,country, number); // TODO format number
            rank.getAndIncrement();
        });
    }

    private static void printHeader(String header) {
        System.out.println(header + "\n");
    }

    private static void printRank(AtomicInteger rank, String key, Object value) {
        System.out.println("\t" + rank + ". " + key + "\t" + value); // TODO this is example of downcasting
    }

    private static CapitalType getCityType(String type) {
        return switch (type) {
            case "primary" -> CapitalType.PRIMARY;
            case "admin" -> CapitalType.ADMIN;
            case "minor" -> CapitalType.MINOR;
            default -> CapitalType.NONE;
        };
    }
}
