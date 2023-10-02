package com.hillel.multi.repository;

import com.hillel.multi.persistent.entity.ClassOrganizer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassOrganizerRepository extends CrudRepository<ClassOrganizer, Integer> {
    @Query("SELECT co FROM ClassOrganizer co WHERE co.student.id = :studentId")
    ClassOrganizer findByStudentId(@Param("studentId") int studentId);
}
