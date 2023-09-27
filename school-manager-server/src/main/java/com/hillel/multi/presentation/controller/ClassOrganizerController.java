package com.hillel.multi.presentation.controller;

import java.util.List;

import com.hillel.multi.infrastructure.exceptions.ClassroomNotFoundException;
import com.hillel.multi.persistent.entity.Classroom;
import com.hillel.multi.persistent.entity.Student;
import com.hillel.multi.service.ClassOrganizerService;
import com.hillel.multi.service.ClassroomService;
import com.hillel.multi.service.dto.StudentDTO;
import com.hillel.multi.service.mapper.StudentMapper;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizer")
@Validated
public class ClassOrganizerController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private ClassOrganizerService classOrganizerService;

    @GetMapping(value = "/{classRange}")
    public ResponseEntity<Object> getAllStudents(@PathVariable("classRange") int classRange,
                                                 @RequestParam(value = "index") String classIndex) {
        Classroom classroom = classroomService.getClassroomByKey(classRange, classIndex);
        if (classroom != null) {
            return (ResponseEntity<Object>) ResponseEntity.status(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classroom not found");
    }

    @PostMapping(
        value = "/add/{classRange}/{index}",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> addStudents(
        @PathVariable("classRange") int classRange,
        @PathVariable("index") String classIndex,
        @Valid @RequestBody List<StudentDTO> studentList) {
        Classroom classroom = classroomService.getClassroomByKey(classRange, classIndex);
        List<Student> dtosToEntities = StudentMapper.INSTANCE.dtosToEntities(studentList);
        if (classroom != null) {

            return ResponseEntity.status(HttpStatus.OK).body(StudentMapper.INSTANCE.entitiesToDtos(classOrganizerService.addStudents(classroom, dtosToEntities)));
        }
        throw new ClassroomNotFoundException("Classroom not found");
    }

    @DeleteMapping(
        value = "/remove/{classRange}/{index}",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> removeStudent(
        @PathVariable("classRange") int classRange,
        @PathVariable("index") String classIndex,
        @Valid @RequestBody Student student) {
        Classroom classroom = classroomService.getClassroomByKey(classRange, classIndex);
        if (classroom == null) {
            throw new ClassroomNotFoundException("Classroom not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(classOrganizerService.removeStudent(classRange, classIndex, student));
    }
}
