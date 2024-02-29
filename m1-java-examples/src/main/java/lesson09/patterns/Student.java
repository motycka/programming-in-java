package lesson09.patterns;

/*
This is a builder pattern example
 */
public class Student {
    private final String name;
    private final int age;
    private final double gpa;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.gpa = builder.gpa;
    }

    public static class Builder {
        private String name;
        private int age;
        private double gpa;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGpa(double gpa) {
            this.gpa = gpa;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
