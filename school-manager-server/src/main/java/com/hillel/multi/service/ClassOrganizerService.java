package com.hillel.multi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hillel.multi.persistent.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class ClassOrganizerService {

    private Map<String, List<Student>> classRepository = new ConcurrentHashMap<>();

    public List<Student> addStudents(String classKey, List<Student> studentList) {
        List<Student> students = classRepository.get(classKey);
        if (students != null) {
            students.addAll(studentList);
        } else {
            students = new ArrayList<>();
            students.addAll(studentList);
        }
        classRepository.put(classKey, students);
        return students;
    }

    public List<Student> removeStudent(String classKey, Student student) {
        List<Student> students = classRepository.get(classKey);
        if (students != null) {
            students.remove(student);
            classRepository.put(classKey, students);
        }
        return students;
    }

    public Map<String, List<Student>> getClassRepository() {
        return classRepository;
    }
}
