package lesson04.inheritance.inheritance;

import lesson04.inheritance.inheritance.model.Cat;
import lesson04.inheritance.inheritance.model.Dog;

public class InheritanceExample {
    public static void main(String[] args) {
        Cat cat = new Cat("meow");
        cat.makeSound();

        Dog dog = new Dog();
        dog.makeSound();

        // this would not compile, because makeRawSound is protected
        // dog.makeRawSound();
    }

}



