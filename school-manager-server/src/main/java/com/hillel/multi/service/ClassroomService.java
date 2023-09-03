package com.hillel.multi.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hillel.multi.persistent.entity.Classroom;
import org.springframework.stereotype.Service;


@Service
public class ClassroomService {

    private final Map<String, Classroom> classroomRepository = new ConcurrentHashMap<>();

    public Classroom createClassroom(Classroom classroom) {
        String classKey = getClassKey(classroom);
        return classroomRepository.put(classKey, classroom);
    }

    public Classroom getClassroomByKey(int classRange, String classIndex) {
        String classKey = getClassKey(classRange, classIndex);
        Classroom classroom = classroomRepository.get(classKey);
        return classroom;
    }

    public Classroom getClassroomByKey(Classroom classroomRequest) {
        String classKey = getClassKey(classroomRequest);
        Classroom classroom = classroomRepository.get(classKey);
        return classroom;
    }

    public Classroom updateClassroom(Classroom classroomToUpdate) {
        String classKey = getClassKey(classroomToUpdate);
        Classroom existingClassroom = classroomRepository.get(classKey);
        existingClassroom.setStudentsNumber(classroomToUpdate.getStudentsNumber());
        classroomRepository.put(classKey, existingClassroom);
        System.out.println(classroomToUpdate);
        return existingClassroom;
    }

    public Classroom deleteClassroom(int classRange, String classIndex) {
        String classKey = getClassKey(classRange, classIndex);
        return classroomRepository.remove(classKey);
    }

    private String getClassKey(Classroom classroom) {
        return getClassKey(classroom.getClassRange(), classroom.getClassIndex());
    }

    private String getClassKey(int classRange, String classIndex) {
        return classRange + classIndex;
    }
}