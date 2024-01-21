package com.motycka.java.practice.lesson4.inheritance.composition;

public class CompositionExample {
    public static void main(String[] args) {
        Cat cat = new Cat("Garfield");
        cat.meow();
    }
}

class Cat {
    private final String name;
    private final Sound sound = new Sound("meow");

    public Cat(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void meow() {
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
