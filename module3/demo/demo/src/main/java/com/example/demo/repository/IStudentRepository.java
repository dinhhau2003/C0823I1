package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
}
