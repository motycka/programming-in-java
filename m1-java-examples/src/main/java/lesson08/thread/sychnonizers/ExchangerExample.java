package lesson08.thread.sychnonizers;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

    private static final Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(new MyRunnable(exchanger), "A").start();
        new Thread(new MyRunnable(exchanger), "B").start();
    }

    static class MyRunnable implements Runnable {
        private final Exchanger<String> exchanger;

        public MyRunnable(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                String message = exchanger.exchange("Hello from " + Thread.currentThread().getName());
                System.out.println("Thread '" + Thread.currentThread().getName() + "' received message: " + message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
