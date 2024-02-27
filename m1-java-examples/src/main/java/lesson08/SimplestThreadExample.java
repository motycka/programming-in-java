package lesson08;

public class SimplestThreadExample {

    public static void main(String[] args) {

        var thread = new Thread(() -> {
            System.out.println("Hello from '" + Thread.currentThread().getName() + "' thread");
        });

        thread.start();

        System.out.println("Hello from '" + Thread.currentThread().getName() + "' thread");
    }

}
