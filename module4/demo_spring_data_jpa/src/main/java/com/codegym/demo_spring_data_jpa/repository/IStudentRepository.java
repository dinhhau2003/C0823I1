package com.codegym.demo_spring_data_jpa.repository;


import com.codegym.demo_spring_data_jpa.model.Student;
import dto.StudentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findStudentByNameContaining(String name);
    Page<Student> findStudentByNameContaining(String name,Pageable pageable);


    @Query(value = "SELECT * FROM student where name like :searchName", nativeQuery = true)
    List<Student> searchByName1(@Param("searchName") String name);

    @Query(value = "select s.id, s.name,c.name as className from student s join classes c on s.class_id = c.id", nativeQuery = true)
    List<StudentInfo> findStudentDTO();



}
