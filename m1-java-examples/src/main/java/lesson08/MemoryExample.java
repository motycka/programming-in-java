package lesson08;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

/*
-verbose:gc

 */
public class MemoryExample {

    private static final Deque<MemoryObject> globalObjects = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) {
        var timer = new Timer();
        int addCount = 1000;
        int addPeriodSeconds = 1000;
        int removePeriod = 100;
        int removeCount = 100;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < addCount; i++) {
                    globalObjects.add(new MemoryObject("Object " + i));
                }
                System.out.println("Created " + addCount + " objects. Total: " + globalObjects.size());

            }
        }, 0, addPeriodSeconds);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < removeCount; i++) {
                    globalObjects.poll();
                }
                System.out.println("Removed " + removeCount + " objects.");
            }
        }, 0, removePeriod);
    }

    static class MemoryObject {

        private final String name;
        private final double[] bigArray = new double[1048576]; // pre-allocated 1MB of memory

        public MemoryObject(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}


