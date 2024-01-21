package com.motycka.java.examples.lesson4.encapsulation;

import java.time.LocalDate;
import java.util.Date;

public class EncapsulationExample {
    public static void main(String[] args) {

    }
}


class UniversityCourse {

    private String subject;
    private LocalDate startDate;

    public UniversityCourse(String subject, LocalDate startDate) {
        this.subject = subject;
        this.startDate = startDate;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Course cannot start in the past");
        } else {
            this.startDate = startDate;
        }
    }
}
