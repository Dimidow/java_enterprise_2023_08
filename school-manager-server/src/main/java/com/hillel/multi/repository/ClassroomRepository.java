package com.hillel.multi.repository;

import com.hillel.multi.persistent.entity.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {

    Classroom findByClassRangeAndClassIndex(int classRange, String classIndex);
}
