package com.motycka.java.practice.lesson4.inheritance.inheritance;

public class InheritanceExample {
    public static void main(String[] args) {
        Cat cat = new Cat("meow");
        cat.makeSound();

        Dog dog = new Dog();
        dog.makeSound();
    }

}


class Animal {
    private final String sound;

    public Animal(String sound){
        this.sound = sound;
    }

    public void makeSound() {
        System.out.println(sound);
    }
}

class BarkingAnimal extends Animal {

    public BarkingAnimal() {
        super("woof");
    }
}

class Cat extends Animal {

    public Cat(String sound) {
        super(sound);
    }
}



class Dog extends BarkingAnimal {

}


