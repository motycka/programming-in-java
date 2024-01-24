package lesson05;

import common.Data;
import common.Examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorsExample {

    public static void main(String[] args) {

        List<String> cities = new ArrayList<>(Data.CITY_LIST);

        Comparator<String> naturalOrder = Comparator.naturalOrder();

        Comparator<String> reverseOrder = Comparator.reverseOrder();

        Comparator<String> byStringLength = Comparator.comparingInt(String::length);

        // custom comparator by occurrence of letter 'a'
        Comparator<String> byOccurrenceOfLetterA = Comparator.comparingLong((str) ->
                str.chars().filter(ch -> ch == 'a').count()
        );

        // passing comparator to sort method as an argument
        cities.sort(byOccurrenceOfLetterA);
        Examples.print(cities);
    }

}
