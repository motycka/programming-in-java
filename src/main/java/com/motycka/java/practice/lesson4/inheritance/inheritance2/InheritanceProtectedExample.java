package com.motycka.java.practice.lesson4.inheritance.inheritance2;

public class InheritanceProtectedExample {
    public static void main(String[] args) {
        Cat cat = new Cat();

        cat.meow();
        cat.makeSound();

//        Animal dog = new Animal("woof");
//        dog.makeSound();
    }
}


class Cat extends Animal {

    public Cat() {
        super("meow", "hiss");
    }

    public void meow() {
        makeSound();
    }

}

class Animal {
    private final String sound1;
    private final String sound2;

    public Animal(String sound1, String sound2) {
        this.sound1 = sound1;
        this.sound2 = sound2;
    }

    protected void makeSound() {
        System.out.println(sound1);
    }
}
