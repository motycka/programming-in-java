package com.motycka.java.practice.lesson4;

import com.motycka.java.practice.lesson6.WorldCity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RankedListPrinter {

    public static void print(String header, List<WorldCity> cities) {
        AtomicInteger rank = new AtomicInteger(1); // TODO explain
        printHeader(header);
        cities.forEach(city -> {
            printRank(rank, city.getName(), city.getPopulation());
            rank.getAndIncrement();
        });
    }

    public static void print(String header, Map<String, Long> cities) {
        AtomicInteger rank = new AtomicInteger(1);
        printHeader(header);
        cities.forEach((country, number) -> {
            printRank(rank, country, number);
            rank.getAndIncrement();
        });
    }

    private static void printHeader(String header) {
        System.out.println(header + "\n");
    }

    private static void printRank(AtomicInteger rank, String key, Object value) {
        System.out.println("\t" + rank + ". " + key + "\t" + value); // TODO format number
    }

}
