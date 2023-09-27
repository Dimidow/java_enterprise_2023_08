package com.hillel.multi.service.mapper;

import com.hillel.multi.persistent.entity.Classroom;
import com.hillel.multi.service.dto.ClassroomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassroomMapper {
    ClassroomMapper INSTANCE = Mappers.getMapper(ClassroomMapper.class);
    ClassroomDTO toClassroomDto(Classroom classroom);
    Classroom dtoToEntity(ClassroomDTO classroomDTO);
}
