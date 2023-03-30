package com.example.studentmanagement;

public class StudentExistsException extends RuntimeException {
    public StudentExistsException(String s) {
        super(s);
    }
}
