package com.songnan.student_exam_system.controller;

import com.mysql.cj.xdevapi.JsonArray;
import com.songnan.student_exam_system.dao.StudentRepository;
import com.songnan.student_exam_system.model.Score;
import com.songnan.student_exam_system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    Iterable<Student> getAllStudentsBasicInfo() {
        return studentRepository.findAll();
    }

//    @GetMapping("/students/{id}")
//    String getStudentBasicInfoById(@PathVariable("id") Integer id) {
//        return studentRepository.findStudentBasicInfoById(id).toString();
//    }

//    @GetMapping("students/{id}/scores")
//    List<Score> getScoreByStudentId(@PathVariable("id") Integer id) {
//        return studentRepository.findById(id).get().getScores();
//    }

//    @RequestMapping(value = "students/update",method = RequestMethod.POST,headers = "Content-Type:application/json")
//    Student updateStudent(Student student) {
//        Student oldStudent = studentRepository.findById(student.getId()).get();
//        student.setScores(oldStudent.getScores());
//        return studentRepository.save(student);
//    }
}
