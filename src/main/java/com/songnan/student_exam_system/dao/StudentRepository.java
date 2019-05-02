package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
