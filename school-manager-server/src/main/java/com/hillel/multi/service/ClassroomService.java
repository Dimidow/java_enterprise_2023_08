package com.hillel.multi.service;

import com.hillel.multi.persistent.entity.Classroom;
import com.hillel.multi.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom getClassroomByKey(int classRange, String classIndex) {
        return classroomRepository.findByClassRangeAndClassIndex(classRange, classIndex);
    }

    public Classroom getClassroomByKey(Classroom classroomRequest) {
        return classroomRepository.findByClassRangeAndClassIndex(classroomRequest.getClassRange(), classroomRequest.getClassIndex());
    }

    public Classroom updateClassroom(Classroom classroomToUpdate) {
        Classroom existingClassroom = getClassroomByKey(classroomToUpdate);
        existingClassroom.setStudentsNumber(classroomToUpdate.getStudentsNumber());
        return classroomRepository.save(existingClassroom);
    }

    public Classroom deleteClassroom(int classRange, String classIndex) {
        Classroom classroomToRemoval = classroomRepository.findByClassRangeAndClassIndex(classRange, classIndex);
        classroomRepository.delete(classroomToRemoval);
        return classroomToRemoval;
    }
}