package com.hillel.multi.repository;

import com.hillel.multi.persistent.entity.ClassOrganizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassOrganizerRepository extends CrudRepository<ClassOrganizer, String> {
}
