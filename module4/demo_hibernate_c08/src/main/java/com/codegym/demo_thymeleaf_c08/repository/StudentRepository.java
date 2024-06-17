package com.codegym.demo_thymeleaf_c08.repository;

import com.codegym.demo_thymeleaf_c08.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{

    @Override
    public List<Student> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
//        TypedQuery<Student> query = session.createQuery("from Student ");
        TypedQuery<Student> query = session.createNativeQuery("select * from student ",Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Student> query = session.createNativeQuery("select * from student where id = :searchId",Student.class);
        query.setParameter("searchId",id);
//        return query.getSingleResult();
        return session.find(Student.class,id);
    }

    @Override
    public boolean save(Student student) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.save(student);
            transaction.commit();
            // nếu xoá
//            Student student1 = findById(student.getId());
//            session.remove(student1);
        }catch (Exception e){
            transaction.rollback();
        }
        return false;
    }
}
