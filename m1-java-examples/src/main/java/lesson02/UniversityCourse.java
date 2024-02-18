package lesson02;

import java.time.LocalDate;

class UniversityCourseExample {

    public static void main(String[] args) {

        UniversityCourse javaCourse = new UniversityCourse("Java", LocalDate.parse("2024-02-19"), 15);

        UniversityCourse pythonCourse = new UniversityCourse("Python");

    }

}

public class UniversityCourse { // access modifier, class keyword, class name

    // class fields
    private String subject; // access modifier, data type, variable name
    private final LocalDate startDate;
    private final int lengthDays;

    // primary constructor - access modifier, LocalDate startDate, name, arguments
    public UniversityCourse(String subject, LocalDate startDate, int lengthDays) {
        // code that will be executed during class instantiation
        this.subject = subject;
        this.startDate = startDate;
        this.lengthDays = lengthDays;
    }

    // secondary constructor
    public UniversityCourse(String subject) {
        this.subject = subject;
        this.startDate = LocalDate.now();
        this.lengthDays = 1;
    }

    // method - access modifier, return type, name, no arguments
    public String getSubject() {
        return subject;
    }

    // method - access modifier, void return type, name, 1 argument
    public void setSubject(String subject) {
        this.subject = subject;
    }

}
