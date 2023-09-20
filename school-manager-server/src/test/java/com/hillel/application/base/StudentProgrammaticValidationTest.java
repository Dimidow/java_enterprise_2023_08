package com.hillel.application.base;

import java.util.Set;

import com.hillel.multi.persistent.entity.Student;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class StudentProgrammaticValidationTest {

    private static final Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Test
    public void testProgrammaticValidation() {
        final Student student = new Student();
        student.setAge(40);
        Set<ConstraintViolation<Student>> validates = validator.validate(student);
        boolean hasAgeViolation = validates.stream()
                                           .anyMatch(violation -> "Student`s age must be from 5 to 16".equals(violation.getMessage()));

        assertFalse(hasAgeViolation);
    }
}
