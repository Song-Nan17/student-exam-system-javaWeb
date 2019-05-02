package com.songnan.student_exam_system.controller;

import com.mysql.cj.xdevapi.JsonArray;
import com.songnan.student_exam_system.dao.StudentRepository;
import com.songnan.student_exam_system.dao.SubjectRepository;
import com.songnan.student_exam_system.model.Score;
import com.songnan.student_exam_system.model.Student;
import com.songnan.student_exam_system.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/students")
    Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    Optional<Student> getStudentById(@PathVariable("id") Integer id) {
        return studentRepository.findById(id);
    }

    @GetMapping("teachers/{teacherId}/students")
    List<Student> getStudentByTeacherId(@PathVariable("teacherId") Integer teacherId) {
        Subject subject = subjectRepository.findByTeacher_Id(teacherId).get();
        return subject.getStudents();
    }

    @PostMapping("students/update")
    Student updateStudent(@RequestParam("id") Integer id,
                          @RequestParam("name") String name,
                          @RequestParam("age") Integer age,
                          @RequestParam("sex") String sex) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        return studentRepository.save(student);
    }
}
