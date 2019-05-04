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
        return subjectRepository.findByTeacher_Id(teacherId);
    }

    @PostMapping("subjects/update")
    Subject updateSubject(
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

    @DeleteMapping("subjects/{id}/delete")
    void deleteSubjectById(@PathVariable("id") Integer id) {
        subjectRepository.deleteById(id);
    }
}
