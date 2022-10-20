package com.service;

import com.HibernateUtil.SessionFactoryProvider;
import com.entities.Marks;
import com.entities.Student;
import com.entities.Subject;
import org.hibernate.Session;

public class SubjectServiceImpl implements SubjectService{
    Student student;
    Subject subject;
    Marks marks;
    @Override
    public void addSubjectToStudent() {

    }

    @Override
    public void addMarkToSubject(int studentId, int subjectId ,int mark) {
        Session session = SessionFactoryProvider.sessionFactoryProviderMethod().openSession();
        session.beginTransaction();
        student= session.get(Student.class,studentId);
        subject = session.get(Subject.class,subjectId);
        marks = new Marks();
        marks.setMarks(mark);
        marks.setStudent(student);
        marks.setSubject(subject);

        subject.getMarks().add(marks);
        student.getMarks().add(marks);
        session.save(marks);
        session.save(subject);
        session.save(student);
        session.getTransaction().commit();

    }
}
