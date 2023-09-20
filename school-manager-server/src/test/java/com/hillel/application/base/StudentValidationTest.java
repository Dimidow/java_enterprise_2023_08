package com.hillel.application.base;

import java.util.Collections;
import java.util.List;

import com.hillel.multi.persistent.entity.Classroom;
import com.hillel.multi.persistent.entity.Student;
import com.hillel.multi.presentation.controller.ClassOrganizerController;
import com.hillel.multi.repository.StudentRepository;
import com.hillel.multi.service.ClassroomService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class StudentValidationTest {


    @InjectMocks
    private ClassOrganizerController classOrganizerController;

    @Mock
    private ClassroomService classroomService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testAddStudentsWithInvalidAge() {
        int classRange = 10;
        String classIndex = "A";
        Classroom classroom = new Classroom();
        Student invalidStudent = new Student();
        invalidStudent.setAge(-3);
        List<Student> studentList = Collections.singletonList(invalidStudent);
        when(classroomService.getClassroomByKey(classRange, classIndex)).thenReturn(classroom);
        try {
            classOrganizerController.addStudents(classRange, classIndex, studentList);
        } catch (ConstraintViolationException e) {
            assertTrue(e.getMessage().contains("Student`s age must be from 5 to 16"));
        }
    }
}