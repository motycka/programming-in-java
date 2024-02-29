package lesson09.patterns;

public class SingletonExample {

    public static void main(String[] args) {
        University university1 = University.getInstance();
        University university2 = University.getInstance();

        System.out.println(university1 == university2); // true
    }
}
