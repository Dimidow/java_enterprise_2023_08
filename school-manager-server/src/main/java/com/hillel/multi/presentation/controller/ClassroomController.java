package com.hillel.multi.presentation.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classroom")
@Validated
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping(value = "/{classRange}")
    public Classroom getClassroom(@PathVariable("classRange") int classRange,
                               @RequestParam(value = "index") String classIndex) {
        return classroomService.getClassroomByKey(classRange, classIndex);
    }

    @PostMapping(
        value = "/create",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> createClassroom(@Valid @RequestBody Classroom classroom) {
        classroomService.addClassroom(classroom);
        return ResponseEntity.ok("Classroom was created: " + String.format("/classroom/%s", classroom.getClassRange() + "?index=" + classroom.getClassIndex()));
    }

    @DeleteMapping(value = "/delete/{classRange}/{classIndex}")
    public ResponseEntity<Long> deleteClassroom(@PathVariable int classRange, @PathVariable String classIndex) {
        var isRemoved = classroomService.deleteClassroom(classRange, classIndex);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
