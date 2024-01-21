package com.motycka.java.practice.lesson4.inheritance.combination;

public class InheritanceCompositionExample {
    public static void main(String[] args) {
        Cat cat = new Cat("Garfield", new Sound("meow"));
        cat.makeSound();
    }
}

class Animal {

    private final Sound sound;

    public Animal(Sound sound){
        this.sound = sound;
    }

    public void makeSound() {
        sound.makeSound();
    }
}

class Sound {
    private final String sound;

    public Sound(String sound){
        this.sound = sound;
    }

    public void makeSound() {
        System.out.println(sound);
    }
}

class Cat extends Animal {
    private final String name;

    public Cat(String name, Sound sound){
        super(sound);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}


