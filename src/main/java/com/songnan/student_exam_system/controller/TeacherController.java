package com.songnan.student_exam_system.controller;

import com.songnan.student_exam_system.dao.SubjectRepository;
import com.songnan.student_exam_system.dao.TeacherRepository;
import com.songnan.student_exam_system.model.Subject;
import com.songnan.student_exam_system.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("teachers/add")
    Teacher addTeacher(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("age") Integer age,
                       @RequestParam("sex") String sex) {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setName(name);
        teacher.setSex(sex);
        teacher.setAge(age);
        return teacherRepository.save(teacher);
    }

    @PostMapping("teachers/{id}/alter")
    Teacher alterSpecifiedTeacher(
            @PathVariable("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("sex") String sex) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setSex(sex);
        return teacherRepository.save(teacher);
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
