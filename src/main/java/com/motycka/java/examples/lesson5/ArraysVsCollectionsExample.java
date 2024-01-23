package com.motycka.java.examples.lesson5;

import java.util.ArrayList;
import java.util.List;

public class ArraysVsCollectionsExample {

    public static void main(String[] args) {

        String[] stringArray = new String[5]; // array of 5 Strings
        stringArray[0] = "A";
        stringArray[1] = "B";
        stringArray[2] = "C";
        stringArray[3] = "D";
        stringArray[4] = "E";
        // no more elements can be added, the array size is fixex


        List<String> stringList = new ArrayList<String>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        stringList.add("E");
        stringList.add("F");
        // we can as many elements as we want
    }

}
