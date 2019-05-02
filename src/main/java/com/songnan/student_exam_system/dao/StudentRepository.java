package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

//
//    @Query("select new com.songnan.student_exam_system.model.Student(s.id, s.name, s.age, s.sex) from Student s")
//    List<Student> findAllStudentsBasicInfo();
//
//    @Query("select new com.songnan.student_exam_system.model.Student(s.id, s.name, s.age, s.sex) from Student s where id = ?1")
//    Student findStudentBasicInfoById(Integer id);
}
