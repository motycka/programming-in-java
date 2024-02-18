package lesson04.inheritance.inheritance.model;

class Animal {
    private final String sound;

    public Animal(String sound) {
        this.sound = sound;
    }

    public void makeSound() {
        System.out.println(sound);
    }

    protected void makeRawSound() {
        System.out.println(sound);
    }
}
