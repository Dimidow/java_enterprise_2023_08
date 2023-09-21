package com.hillel.multi.service.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;


@Target({METHOD, CONSTRUCTOR, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = StudentAgeValidator.class)
public @interface StudentAge {

    String message() default "Student`s age must be from 5 to 16";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
