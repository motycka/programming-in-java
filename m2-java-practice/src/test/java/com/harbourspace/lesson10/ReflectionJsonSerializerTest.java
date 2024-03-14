package com.harbourspace.lesson10;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionJsonSerializerTest {

    @Test
    void testSerialize() throws IllegalAccessException {
        Student student = new Student();
        student.setId(1L);
        student.setFullName("John Doe");
        student.setCourse(3);
        student.setEnrolled(true);
        student.setAdmissionDate(LocalDate.of(2020, 1, 1));
        // Graduation date and grade are left null to test optional serialization

        String json = ReflectionJsonSerializer.serialize(student);
        // The exact JSON string might vary based on field ordering
        assertNotNull(json);
        assertTrue(json.contains("\"id\":1"));
        assertTrue(json.contains("\"fullName\":\"John Doe\""));
        // Add more assertions as necessary
    }
}
