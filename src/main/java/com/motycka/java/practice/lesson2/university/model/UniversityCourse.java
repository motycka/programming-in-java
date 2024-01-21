package com.motycka.java.practice.lesson2.university.model;

import java.time.LocalDate;

public class UniversityCourse {

    {
        System.out.println("INIT");
    }

    final private String subject;
    final private LocalDate startDate;
    final private int lengthDays;

    public UniversityCourse(String subject, LocalDate startDate, int lengthDays) {
        this.subject = subject;
        this.startDate = startDate;
        this.lengthDays = lengthDays;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getLengthDays() {
        return lengthDays;
    }

    public int getDaysRemaining() {
        return 0;
    }

    public int getHoursRemaining() {
        return 0;
    }

//    public void setSubject(String subject) {
//        this.subject = subject;
//    }

}
