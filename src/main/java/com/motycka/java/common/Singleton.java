package com.motycka.java.common;

public class Singleton {
    // Static member holds only one instance of the Singleton class
    private static Singleton singletonInstance;

    // Singleton prevents any other class from instantiating
    private Singleton() {
    }

    // Global access point
    public static Singleton getInstance() {
        // Lazy initialization
        if (singletonInstance == null) {
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }
}
