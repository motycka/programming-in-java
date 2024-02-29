package lesson09.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAsArgumentExample {

    public static void main(String[] args) {

        Integer result = execute("Hello Function!", (input) -> {
            // your code
            System.out.println("Got input: " + input);
            return input.length();
        });

        System.out.println(result);

        Boolean result2 = execute("12.34", 12.34, (p1, p2) -> {
            // your code
            return Double.parseDouble(p1) == p2;
        });

        System.out.println(result2);

    }

    private static Integer execute(String input, Function<String, Integer> function) {
        return function.apply(input);
    }

    private static Boolean execute(String input1, Double input2, BiFunction<String, Double, Boolean> function) {
        return function.apply(input1, input2);
    }

}
