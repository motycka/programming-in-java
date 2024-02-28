package lesson08.thread.sychnonizers;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        var barrier = new CyclicBarrier(3, () -> System.out.println("Barrier reached"));

        new Thread(new MyRunnable(barrier), "A").start();
        new Thread(new MyRunnable(barrier), "B").start();
        new Thread(new MyRunnable(barrier), "C").start();
    }

    static class MyRunnable implements Runnable {
        private final CyclicBarrier barrier;

        public MyRunnable(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread '" + Thread.currentThread().getName() + "' is waiting on the barrier");
                barrier.await();
                System.out.println("Thread '" + Thread.currentThread().getName() + "' has passed the barrier");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
