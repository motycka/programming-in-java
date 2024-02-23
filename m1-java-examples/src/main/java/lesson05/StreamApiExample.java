package lesson05;

import common.Data;
import common.Examples;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class StreamApiExample {

    public static List<String> data = Data.CITY_LIST;

    public static void main(String[] args) {
        filteringExample();
        sortingExample();
        mappingExample();
        reducingExample();
        groupingExample();
        otherExamples();
    }

    private static void filteringExample() {

        List<String> citiesStartingWith = data
                .stream() // creates Stream
                .filter(item -> item.startsWith("A")) // filters and returns Stream
                .toList(); // converts Stream to List

        System.out.println("Filtering example:");
        Examples.print(citiesStartingWith);
    }

    private static void sortingExample() {

        List<String> sortedCities = data
                .stream() // creates Stream
                .sorted(Comparator.reverseOrder()) // compares using the comparator
                .toList(); // converts Stream to List

        System.out.println("Sorting example:");
        Examples.print(sortedCities);
    }

    private static void mappingExample() {
        List<String> mappedCities = data
                .stream() // creates Stream
                .map(item -> {
                    // converts to upper case and removes all vowels
                    return item.toUpperCase().replaceAll("[AEIOUY]", "");
                }) // compares using the comparator
                .toList(); // converts Stream to List

        System.out.println("Mapping example:");
        Examples.print(mappedCities);
    }

    private static void reducingExample() {
        int reducedCities = data
                .stream() // creates Stream
                .map(String::length) // or mapToInt(String::length)
                .reduce(0, Integer::sum);

        System.out.println("Reducing example: " + reducedCities);
    }

    private static void groupingExample() {
        Map<String, List<String>> groupedCities = data
                .stream() // creates Stream
                .collect(Collectors.groupingBy(s -> String.valueOf(s.charAt(0))));

        System.out.println("Grouping example:");
        Examples.print(groupedCities);
    }

    private static void otherExamples() {

        var allMatch = data.stream().allMatch(item -> item.length() == 5);
        var anyMatch = data.stream().anyMatch(item -> item.length() == 5);

        var stream = data.stream().peek(System.out::println);
        var stream3 = data.stream().limit(3);

        System.out.println("All match: " + allMatch);
        System.out.println("Any match: " + anyMatch);
    }

}
