package com.hillel.multi.presentation.controller;

import com.hillel.api.ClassroomApi;
import com.hillel.multi.persistent.entity.Classroom;
import com.hillel.multi.service.ClassroomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classroom")
@Validated
public class ClassroomController implements ClassroomApi {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping(value = "/{classRange}")
    public ResponseEntity<Object> getClassroom(@PathVariable("classRange") int classRange,
                                               @RequestParam(value = "index") String classIndex) {
        Classroom classroom = classroomService.getClassroomByKey(classRange, classIndex);
        if (classroom != null) {
            return ResponseEntity.status(HttpStatus.OK).body(classroom);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classroom not found");
    }

    @PostMapping(
        value = "/create",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> createClassroom(@Valid @RequestBody Classroom classroomRequest) {
        Classroom classroom = classroomService.getClassroomByKey(classroomRequest);
        String message;
        HttpStatus httpStatus;
        if (classroom != null) {
            message = "Classroom already exist";
            httpStatus = HttpStatus.CONFLICT;
        } else {
            classroomService.createClassroom(classroomRequest);
            String classroomUrl = String.format("/classroom/%s?index=%s", classroomRequest.getClassRange(), classroomRequest.getClassIndex());
            message = "Classroom was created: " + classroomUrl;
            httpStatus = HttpStatus.OK;
        }
        return ResponseEntity.status(httpStatus).body(message);
    }

    @PutMapping(value = "/update",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateClassroom(@Valid @RequestBody Classroom classroomRequest) {
        Classroom classroom = classroomService.getClassroomByKey(classroomRequest);
        String message;
        HttpStatus httpStatus;
        if (classroom != null) {
            classroomService.updateClassroom(classroomRequest);
            message = "Classroom updated successfully";
            httpStatus = HttpStatus.OK;
        } else {
            classroomService.createClassroom(classroomRequest);
            message = "Classroom created successfully";
            httpStatus = HttpStatus.CREATED;
        }
        return ResponseEntity.status(httpStatus).body(message);
    }

    @DeleteMapping(value = "/delete/{classRange}/{classIndex}")
    public ResponseEntity<String> deleteClassroom(@PathVariable int classRange, @PathVariable String classIndex) {
        Classroom classroom = classroomService.getClassroomByKey(classRange, classIndex);
        String message;
        HttpStatus httpStatus;
        if (classroom != null) {
            classroomService.deleteClassroom(classRange, classIndex);
            message = "Classroom was removed";
            httpStatus = HttpStatus.OK;
        } else {
            message = "Classroom not found";
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(httpStatus).body(message);
    }
}
