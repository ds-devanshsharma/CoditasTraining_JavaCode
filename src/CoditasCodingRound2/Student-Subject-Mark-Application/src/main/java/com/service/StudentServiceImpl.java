package com.service;

import com.HibernateUtil.SessionFactoryProvider;
import com.entities.Student;
import com.entities.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StudentServiceImpl implements StudentService{
    Student student;
    Subject subject;

    SessionFactory sessionFactory = SessionFactoryProvider.sessionFactoryProviderMethod();
    @Override
    public String registerStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(student);
            session.getTransaction().commit();
            return "Registered";
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return "Failed";
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            System.out.println(id);
            session.delete(session.get(Student.class,id));
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e ){
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    @Override
    public List<Student> showStudentList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.createQuery("from Student").list();
    }

    @Override
    public boolean  updateStudent(int id , HttpServletRequest req) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        student = session.get(Student.class,id);
        if(student == null) return false;
        List<Subject > subjectList = student.getSubjectList();
        subject = new Subject();
        subject.setSubjectName(req.getParameter("subject"));
        subjectList.add(subject);
        student.setSubjectList(subjectList);
        try {
            session.saveOrUpdate(student);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Student showStudentBasedOnID(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        student = session.find(Student.class,id);
        return student;
    }
}
