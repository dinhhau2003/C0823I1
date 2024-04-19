package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> students=new ArrayList<>();
    static {
        students.add(new Student(1,"chánh1"));
        students.add(new Student(2,"chánh2"));
        students.add(new Student(3,"chánh3"));
    }
    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(int id) {
        for (Student s: students){
            if (s.getId()==id){
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean save(Student student) {
        return students.add(student);
    }
}
