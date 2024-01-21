package com.motycka.java;

public class Multithreading {
//    static AtomicBoolean isLocked = new AtomicBoolean(false);

//    static boolean isLocked = false;

    public static void main(String[] args) {
        Worker worker = new Worker();

        new Thread(() -> worker.doWork("Task 1")).start();
        new Thread(() -> worker.doWork("Task 2")).start();
    }

//    public static void main(String[] args) {
//        boolean isLocked = false;
//        new Thread(() -> doWork("Worker 1", isLocked)).start();
//        System.out.println(isLocked);
//        System.out.println(isLocked);
//        System.out.println(isLocked);
//        new Thread(() -> doWork("Worker 2", isLocked)).start();
//        System.out.println(isLocked);
//        System.out.println(isLocked);
//        System.out.println(isLocked);
//    }
//
//
//    static void doWork(String workerName, boolean isLocked) {
//        try {
//            while (isLocked) {
//                System.out.println(workerName + ": waiting for lock to be released");
//                Thread.sleep(1000);
//            }
//
//            isLocked = true;
//            System.out.println(workerName + ": started working");
//            Thread.sleep(5000);
//            System.out.println(workerName + ": finished");
//            isLocked = false;
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

class Worker {

//    private final String workerName;
    private boolean isLocked = false;

//    public Worker(String workerName) {
//        this.workerName = workerName;
//    }

    public void doWork(String task) {
        try {
            while (isLocked) {
                System.out.println(task + ": waiting for lock to be released");
                Thread.sleep(1000);
            }

            isLocked = true;
            System.out.println(task + ": started working");
            Thread.sleep(5000);
            System.out.println(task +  ": finished");
            isLocked = false;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


//class Worker {
//
//    private final String workerName;
//
//    public Worker(String workerName) {
//        this.workerName = workerName;
//    }
//
//    public void doWork(boolean isLocked) {
//        try {
//            while (isLocked) {
//                System.out.println(this.workerName + ": waiting for lock to be released");
//                Thread.sleep(1000);
//            }
//
//            isLocked = true;
//            System.out.println(this.workerName + ": started working");
//            Thread.sleep(5000);
//            System.out.println(this.workerName +  ": finished");
//            isLocked = false;
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}


//class Worker implements Runnable {
//
//    private long counter = 0;
//
//    @Override
//    public void run() {
//        try {
//            Thread.sleep(1000);
//            counter++;
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public long getCounter() {
//        return this.counter;
//    }
//}
