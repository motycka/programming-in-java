package com.motycka.java.examples.lesson1;

public class PrimitiveTypes {

    public static void main(String[] args) {

        boolean isTruthy = true;
        byte index = 127;
        short smallNumber = 32767;
        int number = 2147483647;
        long bigNumber = 9223372036854775807L; // notice L at the end
        float decimalNumber = 123.12346f; // notice f at the end
        double preciseNumber = 123.12345886230469;
        char character = 'a';

        System.out.println(isTruthy);
        System.out.println(index);
        System.out.println(smallNumber);
        System.out.println(number);
        System.out.println(bigNumber);
        System.out.println(decimalNumber);
        System.out.println(preciseNumber);
        System.out.println(character);

    }

}
