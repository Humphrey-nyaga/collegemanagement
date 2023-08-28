package com.example.collegemanagement.student;

import com.example.collegemanagement.exception.StudentExistsException;
import com.example.collegemanagement.exception.StudentNotFoundException;
import com.example.collegemanagement.student.Student;
import com.example.collegemanagement.student.StudentRepository;
import com.example.collegemanagement.student.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        studentService = new StudentService(studentRepository);
    }

    @Test
    void testFindAllStudents() {
        // Given
        List<Student> students = Arrays.asList(
                new Student("John Doe", "123 Main St, New York, USA", "Computer Science", new Date(), "johndoe@example.com"),
                new Student("Harry Wells", "456 Main St, Austin, USA", "Chemistry", new Date(), "harrywells@example.com")
        );
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.findAllStudents();
        verify(studentRepository, times(1)).findAll();
        Assertions.assertEquals(students.size(), result.size());
    }

    @Test
    void testAddStudent() {
        // Given
        Student newStudent = new Student("John Doe", "123 Main St, Austin, USA", "Computer Science", new Date(), "johndoe@example.com");
        when(studentRepository.findByEmail(newStudent.getEmail())).thenReturn(Optional.empty());
        when(studentRepository.save(any())).thenReturn(newStudent);

        // When
        Student result = studentService.addStudent(newStudent);

        // Then
        verify(studentRepository, times(1)).findByEmail(newStudent.getEmail());
        verify(studentRepository, times(1)).save(any());
        Assertions.assertEquals(newStudent, result);
    }

    @Test
    void testAddStudentAlreadyExists() {
        Student newStudent = new Student("John Doe", "123 Main St, Austin, USA", "Computer Science", new Date(), "johndoe@example.com");
        when(studentRepository.findByEmail(newStudent.getEmail())).thenReturn(Optional.of(newStudent));
        Assertions.assertThrows(StudentExistsException.class, () -> studentService.addStudent(newStudent));
    }

    @Test
    void testUpdateStudent() {
        // Given
        Student existingStudent = new Student("John Doe", "123 Main St, Austin, USA", "Computer Science", new Date(), "johndoe@example.com");
        existingStudent.setId(1L);
        when(studentRepository.findById(existingStudent.getId())).thenReturn(Optional.of(existingStudent));
        when(studentRepository.save(any())).thenReturn(existingStudent);

        // When
        Student result = studentService.updateStudent(existingStudent);

        // Then
        verify(studentRepository, times(1)).findById(existingStudent.getId());
        verify(studentRepository, times(1)).save(any());
        Assertions.assertEquals(existingStudent, result);
    }

    @Test
    void testUpdateStudentNotFound() {
        // Given
        Student newStudent = new Student("John Doe", "123 Main St, Austin, USA", "Computer Science", new Date(), "johndoe@example.com");
        newStudent.setId(1L);
        when(studentRepository.findById(newStudent.getId())).thenReturn(Optional.empty());

        // When / Then
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.updateStudent(newStudent));
    }
}

