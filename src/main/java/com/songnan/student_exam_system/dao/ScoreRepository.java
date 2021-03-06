package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.Score;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
    Iterable<Score> findByStudentId(Integer id);

    Iterable<Score> findBySubjectId(Integer id);

    Optional<Score> findByStudentIdAndSubjectId(Integer studentId, Integer subjectId);
}
