package com.example.collegemanagement.professor;

import com.example.collegemanagement.course.Course;
import com.example.collegemanagement.department.Department;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(nullable = true)
    private String middleName;
    private String dob;
    @Column(unique = true)
    private String nationalID;
    private String gender;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
     private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private EmployeeContractType employeeContractType;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonManagedReference
    private Department department;

    @OneToMany(mappedBy = "instructor")
    @JsonBackReference
    private List<Course> courses;

    public Professor() {
    }

    public Professor(String firstName, String lastName, String middleName, String dob, String nationalID, String gender, String email, String phoneNumber,  EmployeeContractType employeeContractType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dob = dob;
        this.nationalID = nationalID;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.employeeContractType = employeeContractType;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public EmployeeContractType getEmployeeContractType() {
        return employeeContractType;
    }

    public void setEmployeeContractType(EmployeeContractType employeeContractType) {
        this.employeeContractType = employeeContractType;
    }
}
