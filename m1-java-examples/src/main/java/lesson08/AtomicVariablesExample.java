package lesson08;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesExample {

    private static final AtomicInteger counter = new AtomicInteger(10);

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (counter.getAndDecrement() > 0) {
                System.out.println("Hello from '" + Thread.currentThread().getName() + "' thread");
            }
        }
    }
}
