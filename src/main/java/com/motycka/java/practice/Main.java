package com.motycka.java.practice;

public class Main {
    public static void main(String[] args) {

//        City bigCity = new City("Bangkok", 1782);
//
//        System.out.println("Hello " + bigCity.getName());
//        System.out.println("You are " + bigCity.getAge() + " years old");

        LiveCity bangkok = new LiveCity("Bangkok", 5000);
        LiveCity prague = new LiveCity("Prague", 2000);

        Thread thread1 = new Thread(bangkok);
        Thread thread2 = new Thread(prague);

        thread1.start();
        thread2.start();

        System.out.println(thread1.getName());
        System.out.println(thread2.getName());

//        while(thread1.isAlive()) {
//            System.out.println(bangkok.getCityName() +  " is still up");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All cities are is sleeping now.");


    }
}
