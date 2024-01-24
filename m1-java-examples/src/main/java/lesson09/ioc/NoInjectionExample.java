package lesson09.ioc;

import lesson09.ioc.model.ElectricEngine;
import lesson09.ioc.model.Engine;

public class NoInjectionExample {

    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
    }

    private static class Car {

        // dependency is hardcoded
        private final Engine engine = new ElectricEngine();

        void start() {
            engine.on();
        }

        void stop() {
            engine.off();
        }

    }
}



