package com.hillel.multi.presentation.controller;

import com.hillel.api.ClassroomApi;
import com.hillel.multi.infrastructure.exceptions.ClassroomConflictException;
import com.hillel.multi.infrastructure.exceptions.ClassroomNotFoundException;
import com.hillel.multi.persistent.entity.Classroom;
import com.hillel.multi.service.ClassroomService;
import com.hillel.multi.service.dto.ClassroomDTO;
import com.hillel.multi.service.mapper.ClassroomMapper;
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
        ClassroomDTO classroomDto = ClassroomMapper.INSTANCE.toClassroomDto(classroomService.getClassroomByKey(classRange, classIndex));
        if (classroomDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(classroomDto);
        }
        throw new ClassroomNotFoundException("Classroom not found");
    }

    @PostMapping(
        value = "/create",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> createClassroom(@Valid @RequestBody ClassroomDTO classroomRequest) {
        Classroom classroom = ClassroomMapper.INSTANCE.dtoToEntity(classroomRequest);
        ClassroomDTO classroomDto = ClassroomMapper.INSTANCE.toClassroomDto(classroomService.getClassroomByKey(classroom));
        HttpStatus httpStatus;
        if (classroomDto != null) {
            throw new ClassroomConflictException("Classroom already exist");
        }
        String classroomUrl = String.format("/classroom/%s?index=%s", classroomRequest.getClassRange(), classroomRequest.getClassIndex());
        httpStatus = HttpStatus.OK;
        return ResponseEntity.status(httpStatus).body(ClassroomMapper.INSTANCE.toClassroomDto(classroomService.createClassroom(classroom)));
    }

    @PutMapping(value = "/update",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateClassroom(@Valid @RequestBody ClassroomDTO classroomRequest) {
        Classroom classroom = ClassroomMapper.INSTANCE.dtoToEntity(classroomRequest);
        ClassroomDTO classroomDto = ClassroomMapper.INSTANCE.toClassroomDto(classroomService.getClassroomByKey(classroom));
        HttpStatus httpStatus;
        if (classroomDto != null) {
            httpStatus = HttpStatus.OK;
            return ResponseEntity.status(httpStatus).body(ClassroomMapper.INSTANCE.toClassroomDto(classroomService.updateClassroom(classroom)));
        }
        httpStatus = HttpStatus.CREATED;
        return ResponseEntity.status(httpStatus).body(ClassroomMapper.INSTANCE.toClassroomDto(classroomService.createClassroom(classroom)));
    }

    @DeleteMapping(value = "/delete/{classRange}/{classIndex}")
    public ResponseEntity<Object> deleteClassroom(@PathVariable int classRange, @PathVariable String classIndex) {
        ClassroomDTO classroomDto = ClassroomMapper.INSTANCE.toClassroomDto(classroomService.getClassroomByKey(classRange, classIndex));
        HttpStatus httpStatus;
        if (classroomDto == null) {
            throw new ClassroomNotFoundException("Classroom not found");
        }
        httpStatus = HttpStatus.OK;
        return ResponseEntity.status(httpStatus).body(ClassroomMapper.INSTANCE.toClassroomDto(classroomService.deleteClassroom(classRange, classIndex)));
    }
}
