package com.hillel.multi.service.mapper;

import java.util.List;

import com.hillel.multi.persistent.entity.Student;
import com.hillel.multi.service.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toStudentDto(Student student);

    Student dtoToEntity(StudentDTO studentDTO);

    List<StudentDTO> entitiesToDtos(List<Student> students);

    List<Student> dtosToEntities(List<StudentDTO> studentDTOs);
}
