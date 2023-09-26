package com.hillel.application.base;

import java.util.Set;

import com.hillel.multi.persistent.entity.Student;
import com.hillel.multi.service.validation.annotation.StudentAge;
import com.hillel.multi.service.validation.annotation.StudentAgeValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest(classes = {StudentAgeValidator.class, ValidationAutoConfiguration.class})
public class StudentAgeValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    public void validate() {
        Student student = new Student();
        student.setAge(40);
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        assertFalse(violations.isEmpty());
        ConstraintViolation<Student> violation = violations.iterator().next();
        assertEquals(StudentAge.class, violation.getConstraintDescriptor().getAnnotation().annotationType());
    }
}