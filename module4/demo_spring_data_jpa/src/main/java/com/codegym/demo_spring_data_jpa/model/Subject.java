package com.codegym.demo_spring_data_jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "subjectList")
    private List<Student> studentList;
}
