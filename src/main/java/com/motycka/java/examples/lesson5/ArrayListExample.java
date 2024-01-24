package com.motycka.java.examples.lesson5;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        // Creating a list
        List<String> list = new ArrayList<>();


        // Adding elements to the list
        list.add("Hello");
        list.add("World");

        // Accessing elements from the list
        System.out.println(list.get(0));
        System.out.println(list.get(1));

        // Removing element from the list
        list.remove(0);

        // Size of list
        int size = list.size();
        System.out.println("Size of list: " + size);

        boolean isEmpty = list.isEmpty();
        System.out.println("Is list empty: " + isEmpty);

        boolean contains = list.contains("World");
        System.out.println("Does list contain 'World': " + contains);

        boolean containsAll = list.containsAll(List.of("Hello", "World"));
        System.out.println("Does list contain 'Hello' and 'World': " + containsAll);

        // Clearing the list
        list.clear();
        System.out.println(list);




        List<Integer> list2 = List.of(1, 2, 3);
        System.out.println(list2);

    }

}
