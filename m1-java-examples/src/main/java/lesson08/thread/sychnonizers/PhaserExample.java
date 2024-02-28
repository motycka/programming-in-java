package lesson08.thread.sychnonizers;

import java.util.concurrent.Phaser;

public class PhaserExample {

    private static final Phaser phaser = new Phaser(2);

    public static void main(String[] args) {
        new Thread(new PreProcessor(phaser), "PRE-PROCESSOR").start();
        new Thread(new PostProcessor(phaser), "POST-PROCESSOR").start();
    }

    static class PostProcessor implements Runnable {
        private final Phaser phaser;

        public PostProcessor(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println("Thread '" + Thread.currentThread().getName() + "' has arriver. Waiting for others...");
            phaser.arriveAndAwaitAdvance();
            System.out.println("Thread '" + Thread.currentThread().getName() + "' has finished.");
        }
    }

    static class PreProcessor implements Runnable {
        private final Phaser phaser;

        public PreProcessor(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread '" + Thread.currentThread().getName() + "' has arrived.");
            phaser.arriveAndDeregister();
            System.out.println("Thread '" + Thread.currentThread().getName() + "' has finished.");
        }
    }

}
