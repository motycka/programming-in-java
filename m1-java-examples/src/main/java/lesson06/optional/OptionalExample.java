package lesson06.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class OptionalExample {

    public static void main(String[] args) {

        // create an instance of Optional
        Optional<String> optional = Optional.ofNullable(getRandomValue());

        // check if the value is present
        boolean isPresent = optional.isPresent();
        System.out.println("Value is present: " + isPresent);

        // you can also use orElse method to provide a default value
        String result = optional.orElse("Optional is cool!");
        System.out.println("Value: " + result);

        // or in a functional way
        String result2 = optional.orElseGet(() -> "Optional is cool!");
        System.out.println("Value: " + result2);

        try {
            // or to throw an exception if the value is not present
            optional.orElseThrow(() -> new RuntimeException("Value was not present"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getRandomValue() {
        List<String> values = Arrays.asList(null, "Java is fun!");
        return values.get(new Random().nextInt(values.size()));
    }
}
