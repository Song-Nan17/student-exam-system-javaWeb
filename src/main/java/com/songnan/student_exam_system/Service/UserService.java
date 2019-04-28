package com.songnan.student_exam_system.Service;

import com.songnan.student_exam_system.model.User;

public class UserService {
    public static boolean isSuperAdmin(User user) {
        return isExist(user) && user.getRole().getRoleName().equals("超级管理员");
    }

    public static boolean isExist(User user) {
        return user != null;
    }
}
