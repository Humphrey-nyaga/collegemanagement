package com.example.collegemanagement.course;

import com.example.collegemanagement.department.Department;
import com.example.collegemanagement.employee.Professor;
import com.example.collegemanagement.semester.Semester;
import com.example.collegemanagement.student.Student;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

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
    private int maxEnrollment;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Professor instructor;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    //course semester
   @ManyToOne
   @JoinColumn(name = "semester_id")
    private Semester semester;


    public Course() {
    }

    public Course(String courseCode, String name, String description, int credits, Professor instructor, Department department, int maxEnrollment) {
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.instructor = instructor;
        this.department = department;
        this.maxEnrollment = maxEnrollment;
    }

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
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", credits=" + credits +
                ", instructor=" + instructor +
                ", department=" + department +
                ", maxEnrollment=" + maxEnrollment +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credits == course.credits && maxEnrollment == course.maxEnrollment && Objects.equals(id, course.id) && Objects.equals(courseCode, course.courseCode) && Objects.equals(name, course.name) && Objects.equals(description, course.description) && Objects.equals(instructor, course.instructor) && Objects.equals(department, course.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseCode, name, description, credits, instructor, department, maxEnrollment);
    }
}
