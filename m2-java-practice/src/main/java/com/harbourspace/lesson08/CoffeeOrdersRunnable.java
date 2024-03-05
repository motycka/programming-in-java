package com.harbourspace.lesson08;

import java.util.concurrent.atomic.AtomicInteger;

public class CoffeeOrdersRunnable implements Runnable {
    private static AtomicInteger orders = new AtomicInteger(10);

    @Override
    public void run() {
        while (orders.get() > 0) {
            try {
                System.out.println("Barista is making your coffee");
                Thread.sleep(5000); // Simulate making a coffee
                System.out.println("----------------------------");
                System.out.println("Your coffee is ready. Enjoy!");
                orders.decrementAndGet(); // Decrease order count
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new CoffeeOrdersRunnable());
        Thread thread2 = new Thread(new CoffeeOrdersRunnable());
        thread1.start();
        thread2.start();
    }
}
