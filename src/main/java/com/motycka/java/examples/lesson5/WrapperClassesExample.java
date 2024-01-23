package com.motycka.java.examples.lesson5;

public class WrapperClassesExample {

    public static void main(String[] args) {

        /*
         Claim: wrapper classes are objects
         */
        Integer number = 42;

        if (number instanceof Object) {
            System.out.println("number is Object");
        } else {
            System.out.println("number is primitive");
        }

        /*
         Claim: wrapper classes are immutable
         */
        Long longNumber = 42L; // this is in fact object instantiation equivalent to calling `new Long(42)`;
        System.out.println(System.identityHashCode(longNumber)); // memory address, something like 2120828836

        longNumber = 24L; // and this is actually equivalent to `number = new Long(24)`
        System.out.println(System.identityHashCode(longNumber)); // the memory address has changed, proving it is a new object

    }

}
