package lesson09.patterns;

public class BuilderPatternExample {

    public static void main(String[] args) {
        Student student = new Student.Builder()
                .setName("John")
                .setAge(20)
                .setGpa(3.5)
                .build();
    }
}
