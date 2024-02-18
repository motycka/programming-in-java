package lesson04.interfaces;

public class InterfaceExample {

    public static void main(String[] args) {
        Cat cat = new Cat();

        cat.makeSound();

        double distance = 3.2;
        double movementTime = cat.move(distance);

        System.out.println("Cat move " + distance + "m in " + movementTime + "s");

        Animal.describe();
    }

}

interface Moving {

    double move(double distance);

}

interface Animal extends Moving, Vocalizing {

    void eat(String food);

    default void sleep(int minutes) {
        System.out.println("sleeps for " + minutes + "minutes");
    }

    static void describe() {
        System.out.println("Generic animal");
    }

}

interface Vocalizing {

    void makeSound();

}

class Cat implements Animal {

    @Override
    public void makeSound() {
        System.out.println("meow");
    }

    @Override
    public double move(double distance) {
        double speed = 2.0;
        return distance / speed;
    }

    @Override
    public void eat(String food) {
        System.out.println("eats " + food);
    }
}
