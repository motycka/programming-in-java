package lesson08;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Thread '" + Thread.currentThread().getName() + "' acquired the semaphore");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Thread '" + Thread.currentThread().getName() + "' releasing the semaphore");
                semaphore.release();
            }
        }
    }
}
