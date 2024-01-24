package common;

import java.util.Collection;

public class Examples {

    public static void print(Collection<String> deque) {
        for (String element : deque) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
