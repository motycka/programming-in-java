package lesson04.abstraction;

public class AbstractClassExample {

    public static void main(String[] args) {
        Animal cat = new Cat("meow"); // Animal reference but Cat object
        cat.makeSound();
    }

}

abstract class Animal {

    // notice the protected modifier
    protected final String sound;

    public Animal(String sound){
        this.sound = sound;
    }

    /*
     Abstract method definition, which a subclass must implement.
     */
    abstract void makeSound();

}

class Cat extends Animal {

    /*
    Compiler will force us to call superclass constructor!
     */
    public Cat(String sound) {
        super(sound);
    }

    /*
     Compiler will force us to use @Override annotation!
     */
    @Override
    void makeSound() {
        // referencing sound in 'this' instance
        System.out.println(this.sound);
    }

}
