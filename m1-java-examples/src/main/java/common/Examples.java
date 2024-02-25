package common;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Examples {

    public static void print(Collection<String> collection) {
        for (String element : collection) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void print(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> element : map.entrySet()) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
