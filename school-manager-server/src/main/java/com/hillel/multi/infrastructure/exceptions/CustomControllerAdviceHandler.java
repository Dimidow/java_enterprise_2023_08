package com.hillel.multi.infrastructure.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomControllerAdviceHandler {

    @ExceptionHandler(ClassroomNotFoundException.class)
    public ResponseEntity handleClassroomNotFoundException(ClassroomNotFoundException classroomDefaultException) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setDescription("An error occurred while processing the request.");
        errorInfo.setErrorType("Classroom API Error");
        errorInfo.setRootCause("Internal Server Error");
        errorInfo.setExceptionMessage(classroomDefaultException.getMessage());
        return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClassroomNotFoundException.class)
    public ResponseEntity handleClassroomConflictException(ClassroomConflictException classroomConflictException) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setDescription("An error occurred while processing the request.");
        errorInfo.setErrorType("Classroom API Error");
        errorInfo.setRootCause("Internal Server Error");
        errorInfo.setExceptionMessage(classroomConflictException.getMessage());
        return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity handleStudentNotFoundException(StudentNotFoundException studentDefaultException) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setDescription("An error occurred while processing the request.");
        errorInfo.setErrorType("Student API Error");
        errorInfo.setRootCause("Internal Server Error");
        errorInfo.setExceptionMessage(studentDefaultException.getMessage());
        return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
