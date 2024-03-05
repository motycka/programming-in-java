package com.harbourspace.lesson08;

public class CoffeeThread {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    System.out.println("Barista is making your coffee");
                    Thread.sleep(5000); // Wait for 5 seconds
                    System.out.println("----------------------------");
                    System.out.println("Your coffee is ready. Enjoy!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
