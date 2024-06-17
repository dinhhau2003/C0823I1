package com.codegym.demo_spring_data_jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
//@Table(name = "sinh_vien")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int gender;
    private String name;


    @OneToOne
    @JoinColumn(name = "s_username")
    private Jame jame;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;


    @ManyToMany
    @JoinTable(name = "student_subject",
    joinColumns =@JoinColumn(name = "student_id"),
     inverseJoinColumns = @JoinColumn(name ="subject_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"student_id","subject_id"})
    )
    private List<Subject> subjectList;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Jame getJame() {
        return jame;
    }

    public void setJame(Jame jame) {
        this.jame = jame;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
