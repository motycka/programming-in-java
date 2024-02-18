package lesson05;

import common.Examples;

import java.util.*;

public class PriorityQueueExample {

    public static void main(String[] args) {

        List<String> cities = Arrays.asList(
                "Bangkok",
                "Los Angeles",
                "Tokyo",
                "London",
                "New York City",
                "Barcelona",
                "Prague",
                "Auckland"
        );

        PriorityQueue<String> naturalOrder = new PriorityQueue<>(cities);

        // convenience method to print the naturalOrder
        Examples.print(naturalOrder);

        naturalOrder.poll(); // returns Athens and removes it from the queue
        Examples.print(naturalOrder);

        // empty PriorityQueue with custom order
        PriorityQueue<String> customOrder = new PriorityQueue<>(
                // custom order based on the length of the strings
                Comparator.comparingInt(String::length)
        );
        // add all elements from the list
        customOrder.addAll(cities);

        // convenience method to print the naturalOrder
        Examples.print(naturalOrder);

        System.out.println("First element to poll: " + customOrder.peek());
        naturalOrder.poll(); // returns Tokyo and removes it from the queue
        Examples.print(naturalOrder);
    }

}
