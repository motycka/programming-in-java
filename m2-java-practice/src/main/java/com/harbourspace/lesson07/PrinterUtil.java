package com.harbourspace.lesson07;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PrinterUtil {

    public static void printAsRankedList(String header, List<City> cities) {
        AtomicInteger rank = new AtomicInteger(1); // TODO explain
        printHeader(header);
        cities.forEach(city -> {
            printRank(rank, city.getName(), city.getPopulation()); // TODO format
            rank.getAndIncrement();
        });
    }

    public static void printAsRankedList(String header, Map<String, Long> cities) {
        AtomicInteger rank = new AtomicInteger(1);
        printHeader(header);
        cities.forEach((country, number) -> {
            printRank(rank,country, number); // TODO format number
            rank.getAndIncrement();
        });
    }

    public static void printHeader(String header) {
        System.out.println(header + "\n");
    }

    public static void printRank(AtomicInteger rank, String key, Object value) {
        System.out.println("\t" + rank + ". " + key + "\t" + value); // TODO this is example of downcasting
    }
}
