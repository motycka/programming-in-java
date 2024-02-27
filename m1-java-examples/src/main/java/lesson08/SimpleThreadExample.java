package lesson08;

public class SimpleThreadExample {

    public static void main(String[] args) {

        var thread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread '" + Thread.currentThread().getName() + "' is running");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Example 1");

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

}
