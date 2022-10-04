package com.StudentApp.StudentApplication.services;

import com.StudentApp.StudentApplication.entities.Student;
import com.StudentApp.StudentApplication.utils.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentDAOImpl implements StudentDAO{
    SessionFactory sessionFactory = SessionProvider.sessionFactoryProvider();
    Student student ;
    Transaction transaction;
    @Override
    public void registerStudent(Student student) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
//        session.save(student.getAddress());
        session.save(student);
        transaction.commit();
    }
    public void deleteStudent(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        student = session.get(Student.class,id);
//        session.delete(student.getAddress());
        session.delete(student);
        session.getTransaction().commit();
    }

    @Override
    public List<Student> fetchAllStudent() {
        Session session = sessionFactory.openSession();
        return session.createQuery("FROM Student").list();
    }
    @Override
    public Student fetchStudentById(int enrollmentID) {
        Session session = sessionFactory.openSession();
        return session.get(Student.class, enrollmentID);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(student);
//        session.saveOrUpdate(student.getAddress());
        session.getTransaction().commit();
    }
}
