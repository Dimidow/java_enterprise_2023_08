package com.hillel.multi.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hillel.multi.persistent.entity.Classroom;
import org.springframework.stereotype.Service;


@Service
public class ClassroomService {

    private final Map<String, Classroom> classroomRepository = new ConcurrentHashMap<>();

    public void addClassroom(Classroom classroom) {
        String classKey = getClassKey(classroom);

        if (classroomRepository.containsKey(classKey)) {
            //"Classroom already exists.";
        }
        classroomRepository.put(classKey, classroom);
    }

    public Classroom getClassroomByKey(int classRange, String classIndex) {
        String classKey = getClassKey(classRange, classIndex);
        Classroom classroom = classroomRepository.get(classKey);

        if (classroom == null) {
            //"Classroom not found";
        }

        return classroom;
    }

    public boolean deleteClassroom(int classRange, String classIndex) {
        String classKey = getClassKey(classRange, classIndex);

        if (!classroomRepository.containsKey(classKey)) {
            return false;
        }

        Classroom removedClassroom = classroomRepository.remove(classKey);
        return removedClassroom != null;
    }

    private String getClassKey(Classroom classroom) {
        return getClassKey(classroom.getClassRange(), classroom.getClassIndex());
    }

    private String getClassKey(int classRange, String classIndex) {
        return classRange + classIndex;
    }
}