package lesson05;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(
                Arrays.asList(
                        "Beijing",
                        "Tokyo",
                        "London",
                        "Paris",
                        "Athens"
                )
        );

        list.addFirst("Bangkok");
        list.addLast("Sydney");

        System.out.println("First element: " + list.getFirst()); // prints "Bangkok"
        System.out.println("Last element: " + list.getLast()); // prints "Sydney"

        list.removeFirst();
        list.removeLast();

        System.out.println("First element: " + list.getFirst()); // prints "Beijing"
        System.out.println("Last element: " + list.getLast()); // prints "Paris"

    }

}
