package com.motycka.java.examples.lesson4.exceptions;

public class CheckedExceptionExample {

    public static void main(String[] args) {

        Car car = new Car(3);

        try {
            car.drive(4);
        } catch (NoFuelException e) { // compiler will force catch block here
            System.out.println(e.getMessage());
            // somehow handle car out of fuel situation
        }
    }

}

class Car {

    private int fuelKm;

    Car(int fuelKm) {
        this.fuelKm = fuelKm;
    }

    void drive(int driveKm) throws NoFuelException {
        while (driveKm > 0) {
            if (fuelKm <= 0) {
                // exception in thrown on car out of fuel event
                throw new NoFuelException();
            } else {
                System.out.println("drove 1 km");
                fuelKm--;
                driveKm--;
            }
        }
    }
}

class NoFuelException extends Throwable {
    NoFuelException() {
        super("The car is out of fuel!");
    }

}
