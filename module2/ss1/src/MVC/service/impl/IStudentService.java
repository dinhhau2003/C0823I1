package MVC.service.impl;

import MVC.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    void add(Student student);
    void delete(int id);
    List<Student> searchName(String searchName);
}
