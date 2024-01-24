package lesson05;

import common.Data;

import java.util.List;

public class ListIterationExample {

    public static void main(String[] args) {

        List<String> list = Data.CITY_LIST;

        for (String item : list) {
            System.out.println(item);
        }

        // using lambda expression
        list.forEach(item -> {
            System.out.println(item);
        });

        // shorthand for the above
        list.forEach(System.out::println);
    }

}
