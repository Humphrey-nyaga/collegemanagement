package com.example.studentmanagement;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentTest {
    @Mock
    private Student student;

    @Test
    public void testStudent() {
        student = new Student("Smith Wales", "12th Avenue St.", "Computer Science", new Date(), "smithwales@example.com");

        assertEquals("Smith Wales", student.getName());
        assertEquals("12th Avenue St.", student.getAddress());
        assertEquals("Computer Science", student.getMajor());
        assertEquals("smithwales@example.com", student.getEmail());
    }
}

