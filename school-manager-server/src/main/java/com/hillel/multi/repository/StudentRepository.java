package com.hillel.multi.repository;

import java.util.List;

import com.hillel.multi.persistent.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.classroom = :classroomId")
    List<Student> findAllByClassroom(@Param("classroomId") int classroomId);
}
