package com.motycka.java.practice.lesson2.objectthis;

import java.time.LocalDate;

public class ThisExample {
    public static void main(String[] args) {

    }
}

class UniversityCourse {

    private final String subject;

    public UniversityCourse(String subject) {
        this.subject = subject; // here you actually have two completely different variables
    }

    public String getSubject() {
        return subject; // no need to use this, since the variable reference is non-ambiguous
    }

    public String getOutline() {
        String subject = "Name: " + this.subject; // here we must specify this due to ambiguity
        System.out.println(subject); // int real life, this could be a logging for debugging purposes
        return subject;
    }

}
