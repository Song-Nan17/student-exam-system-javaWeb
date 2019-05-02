package com.songnan.student_exam_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
//@NamedQuery(name = "Student.findAllStudentsBasicInfo", query = "select new com.songnan.student_exam_system.model.Student(s.id, s.name, s.age, s.sex) from Student s")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String sex;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
//    @JsonManagedReference
//    @JsonIgnore
//    private List<Score> scores;

    @ManyToMany(mappedBy = "students")
    @JsonBackReference
    private List<Subject> subjects;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

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

//    public List<Score> getScores() {
//        return this.scores;
//    }
//
//    public void setScores(List<Score> scores) {
//        this.scores = scores;
//    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "学号：" + this.id +
                ", 姓名：" + this.name +
                ", 年龄：" + this.age +
                ", 性别：" + this.sex;
    }
}
