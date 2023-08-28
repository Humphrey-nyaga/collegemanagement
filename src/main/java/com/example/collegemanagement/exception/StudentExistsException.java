package com.example.collegemanagement.exception;

public class StudentExistsException extends RuntimeException {
    public StudentExistsException(String s) {
        super(s);
    }
}
