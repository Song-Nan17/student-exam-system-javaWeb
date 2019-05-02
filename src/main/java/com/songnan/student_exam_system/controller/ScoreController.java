package com.songnan.student_exam_system.controller;

import com.songnan.student_exam_system.dao.ScoreRepository;
import com.songnan.student_exam_system.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping("/scores")
    Iterable<Score> getScores() {
        return scoreRepository.findAll();
    }

    @GetMapping("/students/{studentId}/scores")
    List<Score> getScoresByStudentId(@PathVariable("studentId") Integer studentId) {
        return scoreRepository.findByStudent_Id(studentId);
    }

    @GetMapping("/scores/update")
    Object updateScore(Object object) {
        return object;
    }
}
