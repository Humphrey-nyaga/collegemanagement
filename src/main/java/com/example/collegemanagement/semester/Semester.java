package com.example.collegemanagement.semester;

import com.example.collegemanagement.course.Course;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String semesterName;

    private Date startDate;

    private Date endDate;


    //list of courses in the semester
    @OneToMany(mappedBy = "semester")
    @JsonManagedReference
    private List<Course> courses;

    public Semester() {}

}
