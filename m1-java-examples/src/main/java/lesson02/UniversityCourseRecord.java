package lesson02;

import java.time.LocalDate;

class UniversityCourseRecordExample {
    public static void main(String[] args) {

        // primary constructor call
        UniversityCourseRecord javaCourse = new UniversityCourseRecord("Java", LocalDate.parse("2024-02-19"), 15);

        // secondary constructor call
        UniversityCourseRecord pythonCourse = new UniversityCourseRecord("Python");

        /*
        This will print:
         UniversityCourseRecord[subject=Java, startDate=2024-02-19, lengthDays=15]

         because the record class has a default toString method
         */
        System.out.println(javaCourse);

        System.out.println(javaCourse.subject());
        System.out.println(javaCourse.startDate());
        System.out.println(javaCourse.lengthDays());
    }
}


record UniversityCourseRecord(
        String subject,
        LocalDate startDate,
        int lengthDays
) {

    // alternative (secondary) constructor
    public UniversityCourseRecord(String subject) {
        this(subject, LocalDate.now(), 1);
    }

}
