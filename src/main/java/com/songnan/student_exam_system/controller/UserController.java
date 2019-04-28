package com.songnan.student_exam_system.controller;

import com.songnan.student_exam_system.Service.UserService;
import com.songnan.student_exam_system.dao.RequestRepository;
import com.songnan.student_exam_system.dao.UserRepository;
import com.songnan.student_exam_system.model.Request;
import com.songnan.student_exam_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RequestRepository requestRepository;


    @PostMapping("/login")
    Iterable<Request> superAdminLogin(String name, String password) {
        Iterable<Request> requests = null;
        User user = getUserByNameAndPassword(name, password);
        if (UserService.isSuperAdmin(user)) {
            requests = getAuthorityRequestsOfSuperAdmin();
        }
        return requests;
    }

    User getUserByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }

    Iterable<Request> getAuthorityRequestsOfSuperAdmin() {
        Iterable<Request> requests = requestRepository.findAll();
        Iterator<Request> iterator = requests.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == 1) {
                iterator.remove();
            }
        }
        return requests;
    }
}
