package com.jpa.hibernate.SpringBootHibernateJPA.service;

import com.jpa.hibernate.SpringBootHibernateJPA.entities.Course;
import com.jpa.hibernate.SpringBootHibernateJPA.entities.Student;
import com.jpa.hibernate.SpringBootHibernateJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void retrieveStudentAndCourses(int studentId) {
        Student student = entityManager.find(Student.class,studentId);
        System.out.println(student);
        System.out.println(student.getCourses());
    }
    @Transactional
    public void insertStudentAndCourse(){
        Student student = new Student();
        student.setStudentName("Devansh");
        entityManager.persist(student);
        Course course = new Course();
        course.setCourseName("SQL");
        entityManager.persist(course);

        student.getCourses().add(course);
        course.getStudents().add(student);
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void addStudentToCourse(int courseId) {
        Course course = entityManager.find(Course.class,courseId);
        if(course!= null ){
            Student student = new Student();
            student.setStudentName("Prateek");
            course.getStudents().add(student);
            student.getCourses().add(course);
            entityManager.persist(student);

        }else{
            System.out.println("Course Not Found !! ");
        }
    }

    @Override
    @Transactional
    public void addCourseToStudent(int studentId) {
        Student student = entityManager.find(Student.class,studentId);
        if(student!=null){
            Course course = new Course();
            course.setCourseName("Zero to hero ");
            course.getStudents().add(student);
            student.getCourses().add(course);
            entityManager.persist(student);
        }
        else{
            System.out.println("Student Not Found !");
        }
    }
}
