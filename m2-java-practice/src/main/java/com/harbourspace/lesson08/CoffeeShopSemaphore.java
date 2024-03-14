package com.harbourspace.lesson08;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Semaphore;

public class CoffeeShopSemaphore implements Runnable {
    private static AtomicInteger orders = new AtomicInteger(10); // Example: 10 orders to process
    private static Semaphore semaphore = new Semaphore(1); // Only 1 coffee machine available

    @Override
    public void run() {
        while (orders.get() > 0) {
            try {
                semaphore.acquire(); // Acquire the semaphore
                if (orders.get() > 0) { // Double check to avoid race condition
                    System.out.println("Barista is making your coffee");
                    Thread.sleep(5000); // Simulate making a coffee
                    System.out.println("Your coffee is ready. Enjoy!");
                    orders.decrementAndGet(); // Decrease order count
                }
                semaphore.release(); // Release the semaphore
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new CoffeeShopSemaphore());
        Thread thread2 = new Thread(new CoffeeShopSemaphore());
        thread1.start();
        thread2.start();
    }
}
