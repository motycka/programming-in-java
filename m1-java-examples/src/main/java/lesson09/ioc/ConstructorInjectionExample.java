package lesson09.ioc;

import lesson09.ioc.model.ElectricEngine;
import lesson09.ioc.model.Engine;

public class ConstructorInjectionExample {

    public static void main(String[] args) {
        // First, we need to create an instance of the dependency
        Engine engine = new ElectricEngine();

        // Then we inject the dependency via constructor
        Car car = new Car(engine);
        car.start();
        car.stop();
    }

    private static class Car {

        private final Engine engine;

        // dependency is injected via constructor
        public Car(Engine engine) {
            this.engine = engine;
        }

        void start() {
            engine.on();
        }

        void stop() {
            engine.off();
        }

    }
}

