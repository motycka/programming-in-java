package com.motycka.java.practice.lesson2;

public class Lesson02StaticClasses {

    public static void main(String[] args) {
        String formattedNumber = StringUtils.formatNumber(12234567890.1234);
        System.out.println(formattedNumber);
    }
}

class OuterClass {

    String name = "A";

    class InnerClass {
        String name = "B";
    }
}


class StringUtils {

    public static int DECIMAL_PLACES = 2;

    public static String formatNumber(double number) {
       return String.valueOf(number);
    }

}
