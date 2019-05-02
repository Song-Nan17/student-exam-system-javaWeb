package com.songnan.student_exam_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
    @JsonManagedReference
    private List<Score> scores;

//    @OneToOne(mappedBy = "subject", cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
//    @JsonBackReference
//    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonManagedReference
    private List<Student> students;


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

    public List<Score> getScores() {
        return this.scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

//    public Teacher getTeacher() {
//        return this.teacher;
//    }
}
