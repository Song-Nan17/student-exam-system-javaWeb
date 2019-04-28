package com.songnan.student_exam_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id
    private String id;

    @Column(name = "role_name")
    private String roleName;

    public Role() {
    }

    public Role(String roleId, String roleName) {
        this.id = roleId;
        this.roleName = roleName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

