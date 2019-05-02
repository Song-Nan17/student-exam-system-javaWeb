package com.songnan.student_exam_system.controller;

import com.songnan.student_exam_system.dao.TeacherRepository;
import com.songnan.student_exam_system.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    Optional<Teacher> getTeacherById(
            @PathVariable("id") Integer id) {
        return teacherRepository.findById(id);
    }
}
