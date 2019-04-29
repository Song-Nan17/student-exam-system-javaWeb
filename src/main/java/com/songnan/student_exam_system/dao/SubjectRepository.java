package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.Score;
import com.songnan.student_exam_system.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
