package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.Score;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
    List<Score> findByStudent_Id(Integer id);
}
