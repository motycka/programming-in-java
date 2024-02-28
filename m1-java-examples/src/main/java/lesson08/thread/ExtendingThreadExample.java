package lesson08.thread;

public class ExtendingThreadExample {

    public static void main(String[] args) {

        new MyThread().start();

        System.out.println("Hello from '" + Thread.currentThread().getName() + "' thread");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from '" + Thread.currentThread().getName() + "' thread");
        }
    }

}
