package com.motycka.examples.lesson3;

import com.motycka.java.examples.lesson2.UniversityCourse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UniversityCourseTest2 {

    private final LocalDate dateNow = LocalDate.now();

    @Test
    @DisplayName("getDaysToStart() should return positive number when course is not started")
    public void testGetDaysToStartNotStarted() {
        int expected = 10;

        UniversityCourse course = new UniversityCourse("Java", dateNow.plusDays(expected), 10);

        Assertions.assertEquals(expected, course.getDaysToStart());
    }

    @Test
    @DisplayName("getDaysToStart() should return 0 when course is already started")
    public void testGetDaysToStartAlreadyStarted() {
        UniversityCourse course = new UniversityCourse("Java", dateNow.minusDays(10), 10);

        Assertions.assertEquals(0, course.getDaysToStart());
    }
}
