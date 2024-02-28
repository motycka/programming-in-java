package lesson08.thread.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    public static void main(String[] args) {

        Messenger messenger = new Messenger();

        Future<String> message = messenger.receiveMessage();

        while (!message.isDone()) {
            System.out.println("Waiting for message...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            System.out.println("Received message: " + message.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class Messenger {

        private final ExecutorService executor = Executors.newSingleThreadExecutor();

        public Future<String> receiveMessage() {
            return executor.submit(() -> {
                Thread.sleep(3000);
                return "Hello from future!";
            });
        }
    }
}
