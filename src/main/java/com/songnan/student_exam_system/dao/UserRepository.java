package com.songnan.student_exam_system.dao;

import com.songnan.student_exam_system.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByNameAndPassword(String name, String password);
}
