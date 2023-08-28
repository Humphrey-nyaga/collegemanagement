package com.example.collegemanagement;

import com.example.collegemanagement.exception.StudentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudentControllerTest {

    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentController = new StudentController(studentService);
    }

    @Test
    public void createStudentTest() {
        Student student = new Student("John", "123 Main St", "Computer Science", new Date(), "john@example.com");
        when(studentService.addStudent(student)).thenReturn(student);
        ResponseEntity<Student> responseEntity = studentController.createStudent(student);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(student, responseEntity.getBody());
    }

    @Test
    public void getAllStudentsTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Harry", "12th Avenue St", "Computer Science", new Date(), "harry@example.com"));
        students.add(new Student("Smith", "11th Avenue St", "Mathematics", new Date(), "smith@example.com"));
        when(studentService.findAllStudents()).thenReturn(students);
        ResponseEntity<List<Student>> responseEntity = studentController.getAllPatients();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(students, responseEntity.getBody());
    }

    @Test
    public void getStudentTest() {
        Long id = 1L;
        Student student = new Student("Harry", "12th Avenue St", "Computer Science", new Date(), "harry@example.com");
        when(studentService.findStudentById(id)).thenReturn(student);
        ResponseEntity<Student> responseEntity = studentController.getStudent(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(student, responseEntity.getBody());
    }

    @Test
    public void getStudentNotFoundTest() {
        Long id = 1L;
        when(studentService.findStudentById(id)).thenThrow(new StudentNotFoundException("Student not found"));
        assertThrows(StudentNotFoundException.class, () -> studentController.getStudent(id));
    }

    @Test
    public void updateStudentTest() {
        Student student = new Student("Harry", "12th Avenue St", "Computer Science", new Date(), "harry@example.com");
        when(studentService.updateStudent(student)).thenReturn(student);
        ResponseEntity<Student> responseEntity = studentController.updateStudent(student);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(student, responseEntity.getBody());
    }

    @Test
    public void deleteStudentTest() {
        Long id = 1L;
        ResponseEntity<?> responseEntity = studentController.deleteStudent(id);
        verify(studentService, times(1)).deleteStudent(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}

