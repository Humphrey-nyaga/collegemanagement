package com.example.collegemanagement.student;

import com.example.collegemanagement.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/")
    ResponseEntity<Student>  createStudent(@RequestBody Student student){
            studentService.addStudent(student);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }


    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllPatients(){
        List<Student> students = studentService.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id")Long id){

        try {
            Student student = studentService.findStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        catch (StudentNotFoundException err){
            throw err;
        }

    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id")Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
