package lesson05;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {

        /*
         Creating a and initializing a map
         */
        TreeMap<Integer, String> map = new TreeMap<>(
                Map.of(
                        7, "Bangkok",
                        -8, "Los Angeles",
                        1, "Prague"
                )
        );

        // adding elements to the map
        map.put(0, "London");
        map.put(10 ,"Sydney");

        // get operation will get its value based on key
        String value = map.get(7);

        // you can test contents of the map
        boolean hasByKey = map.containsKey(7);
        boolean hasByValue = map.containsValue("Bangkok");

        /*
         removing elements
         */
        map.remove(0);
        map.remove(10, "Sydney"); // removes only if the value is 10

        /*
        Accessing elements of a map
         */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // you can also iterate through the keys
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + " Value: " + map.get(key));
        }

        // or you can iterate values
        for (String val : map.values()) {
            System.out.println("Value: " + val);
        }

    }

}
