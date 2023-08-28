package com.example.collegemanagement.department;

import com.example.collegemanagement.employee.Professor;
import com.example.collegemanagement.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String cod;
    private int numberOfCourses;
    private String building;
    private int floorNumber;
    private String roomNumber;
    private String email;

    @OneToMany(mappedBy = "department")
    @JsonBackReference
    private List<Professor> professors;

    @OneToMany(mappedBy = "department")
    @JsonBackReference
    private List<Student> students;

    public Department() {
    }

    public Department(String name, String cod, int numberOfCourses, String building, int floorNumber, String roomNumber, String email) {
        this.name = name;
        this.cod = cod;
        this.numberOfCourses = numberOfCourses;
        this.building = building;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", cod='" + cod + '\'' +
                ", numberOfCourses=" + numberOfCourses +
                ", building='" + building + '\'' +
                ", floorNumber=" + floorNumber +
                ", roomNumber='" + roomNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
