package com.example.studentmanagement.exception;

public class StudentExistsException extends RuntimeException {
    public StudentExistsException(String s) {
        super(s);
    }
}
