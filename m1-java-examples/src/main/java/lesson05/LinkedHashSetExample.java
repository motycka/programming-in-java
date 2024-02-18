package lesson05;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {

    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>(
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

        // "Bangkok" already exists in the set, so it will not be added
        set.add("Bangkok");

        System.out.println(set.size());

        for (String city : set) {
            System.out.println(city);
        }
    }

}
