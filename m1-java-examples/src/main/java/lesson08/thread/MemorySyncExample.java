package lesson08.thread;

public class MemorySyncExample {

    private static /*volatile*/ int sharedCounter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(MemorySyncExample::incrementCounter);
        Thread thread2 = new Thread(MemorySyncExample::incrementCounter);

        thread1.start();
        thread2.start();

        // wait for both threads to finish
        thread1.join();
        thread2.join();

        System.out.println("Final Counter Value: " + sharedCounter);
    }

    private static /*synchronized*/ void incrementCounter() {
        for (int i = 0; i < 10000; i++) {
            sharedCounter++;
        }
    }
}
