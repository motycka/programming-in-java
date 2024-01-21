package com.motycka.java.examples.lesson4.exceptions;

public class UncheckedExceptionExample {

    public static void main(String[] args) {

        int dividend = 100;
        int divisor = 0;

//        int number = 100 / 0; // will end with "Exception in thread "main" java.lang.ArithmeticException: / by zero"

        try {
            int quotient = dividend / divisor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
