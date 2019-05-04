package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    Optional<Subject> findByTeacherId(Integer id);
}
