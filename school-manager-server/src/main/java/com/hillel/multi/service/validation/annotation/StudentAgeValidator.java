package com.hillel.multi.service.validation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudentAgeValidator implements ConstraintValidator<StudentAge, Integer> {

    @Override
    public void initialize(StudentAge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer == null) {
            return false;
        }
        return integer >= 5 && integer <= 16;
    }
}
