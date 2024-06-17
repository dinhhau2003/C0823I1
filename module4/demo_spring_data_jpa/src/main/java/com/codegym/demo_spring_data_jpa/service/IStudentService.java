package com.codegym.demo_spring_data_jpa.service;

import com.codegym.demo_spring_data_jpa.exception.AdminExeption;
import com.codegym.demo_spring_data_jpa.model.Student;
import dto.StudentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<StudentInfo> findStudentDtoAll();
    List<Student> searchByName(String name);
    Page<Student> searchByName(String name,Pageable pageable);

    Student findById(int id);
    boolean save(Student student) throws AdminExeption;
}
