package lesson09.ioc;

import lesson09.ioc.model.ElectricEngine;
import lesson09.ioc.model.Engine;

class SetterInjectionExample {

    public static void main(String[] args) {
        // First, we need to create an instance of the dependency
        ElectricEngine engine = new ElectricEngine();

        // Then we create an instance of the class that has the dependency
        Car car = new Car();

        // Then we inject the dependency via setter
        car.setEngine(engine);
        car.start();
        car.stop();
    }

    private static class Car {

        private Engine engine;

        // dependency is injected via setter
        void setEngine(Engine engine) {
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

