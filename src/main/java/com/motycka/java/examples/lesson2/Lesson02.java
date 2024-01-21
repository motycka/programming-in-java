package com.motycka.java.examples.lesson2;

import java.time.LocalDate;

class Lesson02 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 2, 17);

        UniversityCourse course = new UniversityCourse("Java", date, 21, 10, "Monika");
        course.addStudent("Monika");

        System.out.println("Days to start: " + course.getDaysToStart());
        System.out.println("Days remaining: " + course.getDaysRemaining());
        System.out.println("Remaining capacity: " + course.getRemainingCapacity());

    }
}
