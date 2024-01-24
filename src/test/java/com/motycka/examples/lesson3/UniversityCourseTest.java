package com.motycka.examples.lesson3;

import com.motycka.java.examples.lesson2.UniversityCourse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

// By convention the name of the test class should be the name of the class under test + "Test"
public class UniversityCourseTest {

    // create new LocalDate object with current date which can be reused in tests
    private final LocalDate dateNow = LocalDate.now();

    @Test // annotation to mark the method as a test
    public void testGetDaysToStartNotStarted() {
        int expected = 10; // expected result

        // create new course with start date in the future
        UniversityCourse course = new UniversityCourse("Java", dateNow.plusDays(expected), 10);

        // assert that the result of getDaysToStart() is equal to expected
        Assertions.assertEquals(expected, course.getDaysToStart());
    }

    @Test
    public void testGetDaysToStartAlreadyStarted() {
        // create new course with start date in the past
        UniversityCourse course = new UniversityCourse("Java", dateNow.minusDays(10), 10);

        //assert that the result of getDaysToStart() is equal to 0
        Assertions.assertEquals(0, course.getDaysToStart());
    }
}
