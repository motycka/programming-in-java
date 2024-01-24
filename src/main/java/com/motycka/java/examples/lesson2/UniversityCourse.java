package com.motycka.java.examples.lesson2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class UniversityCourse {

    private final String subject;
    private final LocalDate startDate;
    private final int length;
    private final int capacity;
    private String teacher = null;
    private ArrayList<String> students = new ArrayList<>();

    public UniversityCourse(String subject, LocalDate startDate, int length, int capacity, String teacher) {
        this.subject = subject;
        this.startDate = startDate;
        this.length = length;
        this.capacity = capacity;
        this.teacher = teacher;
    }

    public UniversityCourse(String subject, LocalDate startDate, int capacity) {
        this.subject = subject;
        this.startDate = startDate;
        this.capacity = capacity;
        this.length = 1;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getLength() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    void addStudent(String name) {
        if (students.size() < capacity) {
            students.add(name);
        } else {
            throw new IllegalStateException("The course is already at full capacity.");
        }
    }

    void removeStudent(String name) {
        students.remove(name);
    }

    LocalDate getEndDate() {
        return startDate.plusDays(length);
    }

    public String getTeacher() {
        return teacher;
    }

    public int getDaysRemaining() {
        LocalDate today = LocalDate.now();

        if (today.isBefore(startDate)) {
            return length;
        } else {
            return Period.between(startDate, today).getDays();
        }
    }

    public int getDaysToStart() {
        LocalDate today = LocalDate.now();

        if (today.isBefore(startDate)) {
            return Period.between(today, startDate).getDays();
        } else {
            return 0;
        }
    }

    int getRemainingCapacity() {
        return capacity - students.size();
    }
}
