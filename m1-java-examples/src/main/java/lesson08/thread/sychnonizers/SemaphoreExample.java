package lesson08.thread.sychnonizers;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        new Thread(new MyRunnable(semaphore), "A").start();
        new Thread(new MyRunnable(semaphore), "B").start();
    }

    static class MyRunnable implements Runnable {

        private final Semaphore semaphore;

        public MyRunnable(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Thread '" + Thread.currentThread().getName() + "' acquired the semaphore");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Thread '" + Thread.currentThread().getName() + "' is releasing the semaphore");
                semaphore.release();
            }
        }
    }
}
