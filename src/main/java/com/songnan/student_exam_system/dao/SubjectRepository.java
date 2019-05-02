package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.Score;
import com.songnan.student_exam_system.model.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    Optional<Subject> findByTeacher_Id(Integer id);
}
