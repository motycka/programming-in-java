package lesson05;

import common.Examples;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ArrayDequeExample {

    public static void main(String[] args) {

        ArrayDeque<String> arrayDeque = new ArrayDeque<>(
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

        // convenience method to print the arrayDeque
        Examples.print(arrayDeque);

        arrayDeque.poll(); // returns Bangkok and removes it from the queue
        Examples.print(arrayDeque);

        arrayDeque.pollLast(); // returns Sydney and removes it from the queue
        Examples.print(arrayDeque);

        String peek = arrayDeque.peek(); // returns Beijing but does not remove it from the queue
        System.out.println("Peek: " + peek);

        String peekLast = arrayDeque.peekLast(); // returns Paris but does not remove it from the queue
        System.out.println("Peek Last: " + peekLast);

        // no element is removed from the queue by peek methods
        Examples.print(arrayDeque);
    }

}
