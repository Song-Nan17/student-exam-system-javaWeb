package com.songnan.student_exam_system.controller;

import com.songnan.student_exam_system.dao.ScoreRepository;
import com.songnan.student_exam_system.dao.StudentRepository;
import com.songnan.student_exam_system.dao.SubjectRepository;
import com.songnan.student_exam_system.model.Score;
import com.songnan.student_exam_system.model.Student;
import com.songnan.student_exam_system.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    Iterable<Score> getScoresByStudentId(
            @PathVariable("studentId") Integer studentId) {
        return scoreRepository.findByStudentId(studentId);
    }

    @GetMapping("subjects/{subjectId}/scores")
    Iterable<Score> getScoresBySubjectId(
            @PathVariable("subjectId") Integer subjectId) {
        return scoreRepository.findBySubjectId(subjectId);
    }

    @PostMapping("scores/update/add")
    Score addStudentScore(@RequestParam("id") Integer id,
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

    @PostMapping("scores/update/alter")
    Score alterScoreByStudentANdSubject(
            @RequestParam("studentId") Integer studentId,
            @RequestParam("subjectId") Integer subjectId,
            @RequestParam("score") Double scoreNum) {
        Score score = scoreRepository.findByStudentIdAndSubjectId(studentId, subjectId).get();
        score.setScore(scoreNum);
        return scoreRepository.save(score);
    }
}
