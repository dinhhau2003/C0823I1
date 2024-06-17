package com.codegym.demo_spring_data_jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "classes")
    private List<Student> studentList;

    public int getId() {
        return id;
    }

    public Classes() {
    }

    public Classes(int id, String name, List<Student> studentList) {
        this.id = id;
        this.name = name;
        this.studentList = studentList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
