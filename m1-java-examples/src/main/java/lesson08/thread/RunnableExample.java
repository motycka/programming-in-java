package lesson08.thread;

public class RunnableExample {

    public static void main(String[] args) {
        var thread = new Thread(new MyRunnable(), "Runner 1");

        System.out.println("Starting thread '" + thread.getName() + "'");

        thread.start();

        try {
            // this will block the main thread until the other thread finishes
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread '" + thread.getName() + "' finished");

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello from '" + Thread.currentThread().getName() + "' thread");
        }
    }

}
