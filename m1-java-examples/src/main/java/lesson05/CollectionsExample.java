package lesson05;

import common.Data;
import common.Examples;

import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {
        emptyCollectionsExample();
        singletonCollectionsExample();
        addingAndRemovingExample();
        sortingExample();
        synchronizedExampleNotThreadSafe();
        synchronizedExampleThreadSafe();
    }

    private static void emptyCollectionsExample() {
        List<Double> immutableEmptyList = Collections.emptyList();
        Set<String> immutableEmptySet = Collections.emptySet();
        Map<Integer, String> emptyMap = Collections.emptyMap();

        System.out.println("Empty list: " + immutableEmptyList);
        System.out.println("Empty set: " + immutableEmptySet);
        System.out.println("Empty map: " + emptyMap);
    }

    private static void singletonCollectionsExample() {
        List<String> singletonList = Collections.singletonList("Bangkok");
        Set<String> singletonSet = Collections.singleton("Bangkok");
        Map<Integer, String> singletonMap = Collections.singletonMap(7, "Bangkok");

        System.out.println("Singleton list: " + singletonList);
        System.out.println("Singleton set: " + singletonSet);
        System.out.println("Singleton map: " + singletonMap);
    }

    private static void comparingElementsExample() {
        List<String> cities = new ArrayList<>(Data.CITY_LIST);

        // returns min element by natural order = Anchorage
        String min = Collections.min(cities);
        System.out.println("Min: " + min);

        // returns max element by natural order = Tokyo
        String max = Collections.max(cities);
        System.out.println("Max: " + max);

        int frequency1 = Collections.frequency(cities, "Bangkok"); // returns 1
        System.out.println("Frequency of Bangkok: " + frequency1);

        int frequency2 = Collections.frequency(cities, "Prague"); // returns 0
        System.out.println("Frequency of Prague: " + frequency2);

        // comparing with custom comparator
        String maxByLength = Collections.max(cities, (o1, o2) -> o1.length() - o2.length());
        System.out.println("Max by length: " + maxByLength);

        // this is really equivalent to Comparator.comparingInt
        Collections.max(cities, Comparator.comparingInt(String::length));
    }

    private static void addingAndRemovingExample() {
        // the list was defined as immutable
        List<String> cities = new ArrayList<>(Data.CITY_LIST);

        // this would throw UnsupportedOperationException, because the list is immutable
        // cities.addAll(Arrays.asList("Amsterdam", "Barcelona", "Bratislava", "Rome"));

        // create a new collection from cities and add new elements
        Collections.addAll(cities, "Amsterdam", "Barcelona", "Bratislava", "Rome");
        Examples.print(cities);

        // replaces all matching elements, returns true if at least one was replaced
        boolean replaced = Collections.replaceAll(cities, "Paris", "Prague");
        System.out.println("Replaced at least one? " + replaced);
    }

    private static void sortingExample() {
        List<String> cities = new ArrayList<>(Data.CITY_LIST);

        // sort in natural order
        Collections.sort(cities);
        Examples.print(cities);

        // sort in reverse order
        Collections.sort(cities, Collections.reverseOrder());
        Examples.print(cities);

        // sort with custom comparator - sorted by 3rd letter
        Collections.sort(cities, (o1, o2) -> o1.substring(2, 3).compareTo(o2.substring(2, 3)));
        Examples.print(cities);

        // shuffle the list
        Collections.shuffle(cities);
        Examples.print(cities);

        // reverse the list
        Collections.reverse(cities);
        Examples.print(cities);
    }

    private static void synchronizedExampleNotThreadSafe() {
        try {
            System.out.println("Source list size: " + Data.CITY_LIST.size());

            // not thread safe
            List<String> list = new ArrayList<>();

            Thread writingThread = new Thread(() -> {
                for (String element : Data.CITY_LIST) {
                    list.add(element);
                }
            });

            Thread readingThread = new Thread(() -> {
                // this will print random result every time it is run
                System.out.println("Synchronized list size: " + list.size());
            });

            writingThread.start();
            readingThread.start();

            writingThread.join();
            readingThread.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void synchronizedExampleThreadSafe() {
        try {
            System.out.println("Source list size: " + Data.CITY_LIST.size());

            // thread safe
            List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());

            Thread writingThread = new Thread(() -> {
                synchronized (synchronizedList) {
                    for (String element : Data.CITY_LIST) {
                        synchronizedList.add(element);
                    }
                }
            });

            Thread readingThread = new Thread(() -> {
                synchronized (synchronizedList) {
                    System.out.println("Synchronized list size: " + synchronizedList.size());
                }
            });

            writingThread.start();
            readingThread.start();

            writingThread.join();
            readingThread.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
