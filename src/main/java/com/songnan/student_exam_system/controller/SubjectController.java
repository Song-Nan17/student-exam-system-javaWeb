package com.songnan.student_exam_system.controller;

import com.songnan.student_exam_system.dao.SubjectRepository;
import com.songnan.student_exam_system.dao.TeacherRepository;
import com.songnan.student_exam_system.model.Subject;
import com.songnan.student_exam_system.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/subjects")
    Iterable<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping("/teachers/{teacherId}/subject")
    Optional<Subject> getSubjectByTeacherId(
            @PathVariable("teacherId") Integer teacherId) {
        return subjectRepository.findByTeacherId(teacherId);
    }

    @PostMapping("subjects")
    Subject addSubject(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("teacherId") Integer teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).get();
        Subject subject = new Subject();
        subject.setId(id);
        subject.setName(name);
        subject.setTeacher(teacher);
        return subjectRepository.save(subject);
    }

    @PutMapping("subjects/{id}")
    Subject alterSpecifiedSubject(
            @PathVariable("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("teacherId") Integer teacherId) {
        Subject subject = subjectRepository.findById(id).get();
        subject.setId(id);
        subject.setName(name);
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.setTeacher(teacher);
        return subjectRepository.save(subject);
    }

    @DeleteMapping("subjects/{id}")
    void deleteSubjectById(@PathVariable("id") Integer id) {
        subjectRepository.deleteById(id);
    }
}
