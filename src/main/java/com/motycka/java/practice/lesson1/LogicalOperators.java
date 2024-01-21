package com.motycka.java.practice.lesson1;

public class LogicalOperators {

    public static void main(String[] args) {

        boolean truthy = true;
        boolean falsy = false;

        System.out.println(truthy && falsy); // yields false
        System.out.println(truthy || falsy); // yields true
        System.out.println(truthy && !falsy); // yields true
        System.out.println(!truthy && falsy); // yields false
    }
}
