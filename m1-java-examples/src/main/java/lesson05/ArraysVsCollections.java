package lesson05;

import java.util.ArrayList;
import java.util.List;

public class ArraysVsCollections {

    public static void main(String[] args) {

        String[] stringArray = new String[5]; // array of 5 Strings
        stringArray[0] = "array element A";
        stringArray[1] = "array element B";
        stringArray[2] = "array element C";
        stringArray[3] = "array element D";
        stringArray[4] = "array element E";
        // no more elements can be added, the array size is fixed

        for (String s : stringArray) {
            System.out.println(s);
        }

        List<String> stringList = new ArrayList<String>();
        stringList.add("List element A");
        stringList.add("List element B");
        stringList.add("List element C");
        stringList.add("List element D");
        stringList.add("List element E");
        stringList.add("List element F");
        // we can as many elements as we want

        for (String s : stringList) {
            System.out.println(s);
        }
    }

}
