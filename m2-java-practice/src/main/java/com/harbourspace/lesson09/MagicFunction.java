package com.harbourspace.lesson09;

import java.util.function.BiFunction;


public class MagicFunction {

    // Task 3: Generic method using BiFunction
    public static <T1, T2, R> R doMagicWithBiFunction(T1 item1, T2 item2, BiFunction<T1, T2, R> magic) {
        return magic.apply(item1, item2);
    }

    // Task 4: Generic method using custom functional interface
    public static <T1, T2, R> R doMagicWithCustomInterface(T1 item1, T2 item2, Magic<T1, T2, R> magic) {
        return magic.apply(item1, item2);
    }

    // Main method for demonstration (Optional)
    public static void main(String[] args) {
        // Task 3
        Integer resultBiFunction = doMagicWithBiFunction("Hello", 5, (str, num) -> str.length() + num);
        System.out.println("Result with BiFunction: " + resultBiFunction);

        // Task 4
        Integer resultCustomInterface = doMagicWithCustomInterface("Hello", 3, (str, num) -> str.length() * num);
        System.out.println("Result with Custom Interface: " + resultCustomInterface);
    }
}
