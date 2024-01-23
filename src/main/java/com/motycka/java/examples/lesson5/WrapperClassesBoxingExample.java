package com.motycka.java.examples.lesson5;

public class WrapperClassesBoxingExample {

    public static void main(String[] args) {

        byte bytePrimitive = 127;
        Byte byteObject = bytePrimitive; // auto-boxing

        System.out.println(bytePrimitive);
        System.out.println(byteObject);


        Integer intObject = 2147483647;
        int intPrimitive = intObject; // auto-unboxing

        System.out.println(intObject);
        System.out.println(intPrimitive);
    }

}
