package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.Score;
import com.songnan.student_exam_system.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
    List<Score> findByStudentId(Integer id);

    Optional<Score> findByStudentIdAndSubjectId(Integer studentId, Integer subjectId);
}
