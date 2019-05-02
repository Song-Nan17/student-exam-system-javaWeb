package com.songnan.student_exam_system.controller;

import com.songnan.student_exam_system.dao.ScoreRepository;
import com.songnan.student_exam_system.dao.StudentRepository;
import com.songnan.student_exam_system.dao.SubjectRepository;
import com.songnan.student_exam_system.model.Score;
import com.songnan.student_exam_system.model.Student;
import com.songnan.student_exam_system.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/scores")
    Iterable<Score> getScores() {
        return scoreRepository.findAll();
    }

    @GetMapping("/students/{studentId}/scores")
    List<Score> getScoresByStudentId(
            @PathVariable("studentId") Integer studentId) {
        return scoreRepository.findByStudent_Id(studentId);
    }

    @PostMapping("scores/update")
    Score updateScore(@RequestParam("id") Integer id,
                      @RequestParam("studentId") Integer studentId,
                      @RequestParam("subjectId") Integer subjectId,
                      @RequestParam("score") Double scoreNum) {
        Student student = studentRepository.findById(studentId).get();
        Subject subject = subjectRepository.findById(subjectId).get();
        Score score = new Score();
        score.setId(id);
        score.setStudent(student);
        score.setSubject(subject);
        score.setScore(scoreNum);
        return scoreRepository.save(score);
    }
}
