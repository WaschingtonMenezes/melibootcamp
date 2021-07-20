package com.exercicio1.obterdiploma.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String subject;
    @NotNull
    private Double note;

//    @ManyToMany
//    private List<Student> studentList;

    public Subject() {
    }

    public Subject(long id, String subject, Double note) {
        this.id = id;
        this.subject = subject;
        this.note = note;
    }

    public Subject(String subject, Double note) {
        this.subject = subject;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public List<Student> getStudentList() {
//        return studentList;
//    }
//
//    public void setStudentList(List<Student> studentList) {
//        this.studentList = studentList;
//    }
}
