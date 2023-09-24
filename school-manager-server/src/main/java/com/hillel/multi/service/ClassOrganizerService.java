package com.hillel.multi.service;

import java.util.ArrayList;
import java.util.List;

import com.hillel.multi.persistent.entity.ClassOrganizer;
import com.hillel.multi.persistent.entity.Classroom;
import com.hillel.multi.persistent.entity.Student;
import com.hillel.multi.repository.ClassOrganizerRepository;
import com.hillel.multi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassOrganizerService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassOrganizerRepository classOrganizerRepository;

    public List<Student> addStudents(Classroom classroom, List<Student> studentList) {

        List<ClassOrganizer> classOrganizers = new ArrayList<>();
        for (Student student : studentList) {
            ClassOrganizer classOrganizer = new ClassOrganizer();
            classOrganizer.setClassroom(classroom);
            classOrganizer.setStudent(student);
            classOrganizers.add(classOrganizer);
            student.setClassroom(classroom.getClassroom_id());
        }
        studentRepository.saveAll(studentList);
        classOrganizerRepository.saveAll(classOrganizers);

        return studentList;
    }

    public List<Student> removeStudent(String classKey, Student student) {
        List<Student> students = null;
        return students;
    }
}
