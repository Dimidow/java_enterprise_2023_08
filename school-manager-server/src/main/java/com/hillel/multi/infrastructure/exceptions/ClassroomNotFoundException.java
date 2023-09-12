package com.hillel.multi.infrastructure.exceptions;

public class ClassroomNotFoundException extends RuntimeException {

    public ClassroomNotFoundException(String message) {
        super(message);
    }
}