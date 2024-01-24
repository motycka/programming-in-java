package lesson05;

import common.Examples;

import java.util.*;

public class TreeSetExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList(
                "Bangkok",
                "Los Angeles",
                "Tokyo",
                "London",
                "New York City",
                "Barcelona",
                "Prague",
                "Auckland"
        );

        // natural order
        TreeSet<String> set = new TreeSet<>(list);

        // "Bangkok" already exists in the set, so it will not be added
        set.add("Bangkok");

        System.out.println(set.size()); // size has not changed, prints 7
        Examples.print(set); // prints: Athens Bangkok Beijing London Paris Sydney Tokyo

        // empty TreeSet with custom order
        TreeSet<String> customOrderSet = new TreeSet<>(
                // custom order based on the length of the strings
                Comparator.comparingInt(String::length)
        );
        // add all elements from the list
        customOrderSet.addAll(list);

        // prints: Tokyo London Bangkok Auckland Barcelona Los Angeles New York City
        Examples.print(customOrderSet);

    }

}
