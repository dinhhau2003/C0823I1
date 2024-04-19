package com.codegym.demo_spring_mvc.repository;

import com.codegym.demo_spring_mvc.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh1"));
        studentList.add(new Student(2,"chánh2"));
        studentList.add(new Student(3,"chánh3"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        for (Student s: studentList) {
            if (s.getId()==id){
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean save(Student student) {
        return studentList.add(student);
    }
}
