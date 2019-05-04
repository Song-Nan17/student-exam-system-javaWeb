package com.songnan.student_exam_system.controller;

import com.songnan.student_exam_system.dao.SubjectRepository;
import com.songnan.student_exam_system.dao.TeacherRepository;
import com.songnan.student_exam_system.model.Subject;
import com.songnan.student_exam_system.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/teachers")
    Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    Optional<Teacher> getTeacherById(
            @PathVariable("id") Integer id) {
        return teacherRepository.findById(id);
    }

    @DeleteMapping("teachers/{id}/delete")
    void deleteTeacherById(@PathVariable("id") Integer id) {
        deleteSubjectOfTeacher(id);
        teacherRepository.deleteById(id);
    }

    void deleteSubjectOfTeacher(Integer teacherId) {
        Subject subject = subjectRepository.findByTeacherId(teacherId).get();
        subjectRepository.delete(subject);
    }
}
