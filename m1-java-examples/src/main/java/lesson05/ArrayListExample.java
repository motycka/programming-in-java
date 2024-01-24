package lesson05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("Example 1: Adding elements");
        System.out.println("---------------------------------");
        addingElements();

        System.out.println("---------------------------------");
        System.out.println("Example 2: Removing elements");
        System.out.println("---------------------------------");
        removingElements();

        System.out.println("---------------------------------");
        System.out.println("Example 3: Working with elements");
        System.out.println("---------------------------------");
        workingWithElements();
    }

    private static void addingElements() {

        // Initializing an empty List
        ArrayList<String> list = new ArrayList<>();

        // Adding elements to the list
        list.add("Bangkok");
        list.add("Beijing");
        list.add("Tokyo");

        // Accessing elements from the list
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        // Initializing a List with elements
        List<String> moreCities = Arrays.asList(
                "London",
                "Paris",
                "Athens"
        );

        // Adding more elements to the list
        list.addAll(moreCities);

        for (String city : list) {
            System.out.println(city);
        }

        // Accessing element from the list that does not exist
        try {
            System.out.println(list.get(11)); // Throws IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) { // Catching the exception
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    private static void removingElements() {
        ArrayList<String> list = new ArrayList<>(
                Arrays.asList(
                        "Bangkok",
                        "Beijing",
                        "Tokyo",
                        "London",
                        "Paris",
                        "Athens",
                        "UNDEFINED",
                        null,
                        "Sydney"
                )
        );

        list.remove("UNDEFINED");
        list.remove(null);
        list.remove(3);
        list.removeAll(List.of("Bangkok", "Pattaya"));

        for (String city : list) {
            System.out.println(city);
        }
    }

    private static void workingWithElements() {
        ArrayList<String> list = new ArrayList<>(
                Arrays.asList(
                        "Bangkok",
                        "Beijing",
                        "Tokyo",
                        "London",
                        "Paris",
                        "Athens",
                        "Sydney"
                )
        );

        // Size of list
        int size = list.size();
        System.out.println("Size of list: " + size);

        // Checking if list is empty
        boolean isEmpty = list.isEmpty();
        System.out.println("Is list empty: " + isEmpty);

        // Checking if list contains an element
        boolean contains = list.contains("Tokyo");
        System.out.println("Does list contain 'Tokyo': " + contains);

        // Checking if list contains all elements
        boolean containsAll = list.containsAll(List.of("Bangkok", "Tokyo"));
        System.out.println("Does list contain 'Bangkok' and 'Tokyo': " + containsAll);

        // Clearing the list
        list.clear();
        System.out.println("Is list empty: " + list.isEmpty());
    }

}
