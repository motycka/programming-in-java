package lesson04.inheritance.inheritance.model;

class BarkingAnimal extends Animal {

    public BarkingAnimal() {
        super("woof");
    }

    public void bark() {
        makeRawSound();
    }
}
