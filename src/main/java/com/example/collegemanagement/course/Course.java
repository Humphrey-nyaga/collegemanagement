package com.example.collegemanagement.course;

import com.example.collegemanagement.department.Department;
import com.example.collegemanagement.employee.Professor;
import com.example.collegemanagement.student.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="course")
public class Course {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
    private String courseCode;
    private String name;
    private String description;
    private int credits;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Professor instructor;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private int maxEnrollment;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Professor getInstructor() {
        return instructor;
    }

    public void setInstructor(Professor instructor) {
        this.instructor = instructor;
    }
}
