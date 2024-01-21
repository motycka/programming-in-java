package com.motycka.java.practice.lesson4.polymorphism.runtime;

public class RuntimePolymorphismExample {
    public static void main(String[] args) {
        Animal animal0 = new Animal();
        // Animal reference but Dog object
        Animal animal1 = new Dog();
        // Animal reference but Cat object
        Animal animal2 = new Cat();

        animal0.makeSound(); // prints "(silence)"
        animal1.makeSound(); // prints "woof"
        animal2.makeSound(); // prints "meow"
    }
}

class Animal {
    void makeSound() {
        System.out.println("(silence)");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("woof");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("meow");
    }
}
