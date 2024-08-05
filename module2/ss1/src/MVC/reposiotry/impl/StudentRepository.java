package MVC.reposiotry.impl;

import MVC.model.Student;
import MVC.reposiotry.IStudentRepository;
import MVC.util.ReadAndWrite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepository implements IStudentRepository {
    private final String STUDENT_FILE="E:\\Codegym\\C0823I1\\module2\\ss1\\src\\MVC\\data\\student.csv";
    static Scanner scanner=new Scanner(System.in);
    @Override

    public List<Student> findAll() {
        List<String> stringList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        stringList = ReadAndWrite.readFromCSV(STUDENT_FILE);
        String[] array =null;
        for (int i = 0; i <stringList.size() ; i++) {
            array = stringList.get(i).split(",");
            Student student = new Student(Integer.parseInt(array[0]), array[1]);
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public List<Student> searchName(String searchName) {
        List<Student> studentList = findAll();
        List<Student> searchList = new ArrayList<>();
        for (int i = 0; i < studentList.size() ; i++) {
            if (studentList.get(i).getName().contains(searchName)){
                searchList.add(studentList.get(i));
            }
        }
        return searchList;
    }

    @Override
    public Student findById(int id) {
        List<Student> studentList = findAll();
        for (int i = 0; i < studentList.size() ; i++) {
            if (studentList.get(i).getId()==id){
                return studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public void add(Student student) {
        ReadAndWrite.writeListToFileCSV2(STUDENT_FILE, student.getInfoToCSV(),true);
    }

    @Override
    public void delete(int id) {
        List<Student> studentList = findAll();
        for (int i = 0; i < studentList.size() ; i++) {
            if (studentList.get(i).getId()==id){
                studentList.remove(i);
            }
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i <studentList.size() ; i++) {
            ReadAndWrite.writeListToFileCSV2(STUDENT_FILE,studentList.get(i).getInfoToCSV(),false);
        }
    }
}
