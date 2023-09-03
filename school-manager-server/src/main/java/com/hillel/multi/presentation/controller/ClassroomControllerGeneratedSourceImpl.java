package com.hillel.multi.presentation.controller;

import java.util.Optional;

import com.hillel.api.ClassroomApi;
import com.hillel.model.Classroom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

@RestController
public class ClassroomControllerGeneratedSourceImpl implements ClassroomApi {

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ClassroomApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> createClassroom(Classroom classroom) {
        return ClassroomApi.super.createClassroom(classroom);
    }

    @Override
    public ResponseEntity<Void> deleteClassRangeClassIndexDelete(Integer classRange, String classIndex) {
        return ClassroomApi.super.deleteClassRangeClassIndexDelete(classRange, classIndex);
    }

    @Override
    public ResponseEntity<Classroom> getClassroom(Integer classRange, String index) {
        return ClassroomApi.super.getClassroom(classRange, index);
    }

    @Override
    public ResponseEntity<Void> updatePut(Classroom classroom) {
        return ClassroomApi.super.updatePut(classroom);
    }
}
