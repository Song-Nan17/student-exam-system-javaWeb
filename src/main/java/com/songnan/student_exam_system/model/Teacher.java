package com.songnan.student_exam_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String sex;

    @OneToOne(mappedBy = "teacher",cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JsonBackReference
    private Subject subject;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
