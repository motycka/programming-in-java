package lesson05;

import common.Data;
import common.Examples;

import java.util.List;


public class StreamApiExample {

    public static List<String> data = Data.CITY_LIST;

    public static void main(String[] args) {
        filteringExample();
    }

    private static void filteringExample() {

        List<String> citiesStartingWith = data
                .stream() // creates Stream
                .filter(item -> item.startsWith("A")) // filters and returns Stream
                .toList(); // converts Stream to List

        Examples.print(citiesStartingWith);
    }
}
