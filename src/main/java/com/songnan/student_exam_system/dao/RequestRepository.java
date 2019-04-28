package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Integer> {
}
