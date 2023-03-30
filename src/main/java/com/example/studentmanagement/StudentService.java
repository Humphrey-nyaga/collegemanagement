package com.example.studentmanagement;

import com.example.studentmanagement.exception.StudentExistsException;
import com.example.studentmanagement.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public Student addStudent(Student student){
            Optional<Student> newStudent = studentRepository.findByEmail(student.getEmail());
            if (newStudent.isPresent()) {
                throw new StudentExistsException("A student with the given email already exists");
            }
            return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findById(student.getId());

        if (existingStudent.isPresent()) {
            return studentRepository.save(student);
        }
        throw new StudentNotFoundException("Student with id " + student.getId() + " not found");

    }
    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student with id: " + " not found."));
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student findStudentByEmail(String email){
        return studentRepository.findByEmail(email)
                .orElseThrow(()-> new StudentNotFoundException("User with Email: " + " not found."));
    }
}
