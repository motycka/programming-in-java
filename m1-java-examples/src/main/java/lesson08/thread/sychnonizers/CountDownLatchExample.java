package lesson08.thread.sychnonizers;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static final CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) {
        var waitingThread = new Thread(() -> {
            System.out.println("Thread '" + Thread.currentThread().getName() + "' started");
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread '" + Thread.currentThread().getName() + "' finished");
        }, "WAITING");


        var countingThread = new Thread(() -> {
            System.out.println("Thread '" + Thread.currentThread().getName() + "' started");
            while (latch.getCount() > 0) {
                System.out.println("Thread '" + Thread.currentThread().getName() + "' counting down " + latch.getCount() + "...");
                latch.countDown();
            }
            System.out.println("Thread '" + Thread.currentThread().getName() + "' finished");
        }, "COUNTING");

        waitingThread.start();
        countingThread.start();
    }

}
