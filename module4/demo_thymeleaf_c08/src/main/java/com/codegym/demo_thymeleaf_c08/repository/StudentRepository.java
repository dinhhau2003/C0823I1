package com.codegym.demo_thymeleaf_c08.repository;

import com.codegym.demo_thymeleaf_c08.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1, 1,"chánh1",new String[]{"Java","PHP","SQL"},1));
        studentList.add(new Student(2, 0,"chánh2",new String[]{"PHP","SQL"},1));
        studentList.add(new Student(3, -1,"chánh3",new String[]{"Java","PHP","SQL"},1));

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
