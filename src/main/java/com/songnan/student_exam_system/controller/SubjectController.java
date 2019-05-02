package com.songnan.student_exam_system.controller;

import com.songnan.student_exam_system.dao.SubjectRepository;
import com.songnan.student_exam_system.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    Iterable<Subject> getSubjects() {
        return subjectRepository.findAll();
    }
//
//    @GetMapping("/teachers/{teacherId}/subject")
//    Subject getSubjectByTeacherId(@PathVariable("teacherId") Integer teacherId) {
//        return subjectRepository.findByTeacher_Id(teacherId);
//    }
}
