package com.service;

import com.bean.Course;
import com.bean.Teacher;
import com.sun.security.auth.callback.TextCallbackHandler;
import com.util.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ServiceImpl implements Service{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    SessionFactory sessionFactory = SessionFactoryProvider.SessionFactoryProviderMethod();
    Teacher teacher;
    Course course;
    Set<Course> courseSet ;
    @Override
    public void registerTeacher() throws IOException {
        teacher = new Teacher();
        System.out.println("Enter Teacher id : ");teacher.setTeacherID(Integer.parseInt(reader.readLine()));
        System.out.println("Enter Teacher name : ");teacher.setTeacherName(reader.readLine());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        System.out.println("Teacher Registered successfully !!");
    }

    @Override
    public void addTeacherCourses() throws IOException {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("Enter Teacher ID : ");
        teacher = session.get(Teacher.class,Integer.parseInt(reader.readLine()));
        if(teacher==null) System.out.println("Teacher not found!!");
        else{
            courseSet = new HashSet<>();
            boolean flag = true;
            int id ;
            while(flag){
                course = new Course();

                System.out.println("Enter course ID : ");
                course.setCourseID(Integer.parseInt(reader.readLine()));
                System.out.println("Enter courseName : ");
                course.setCourseName(reader.readLine());
                course.setTeacher(teacher);
                courseSet.add(course);
//                session.save(course);
                System.out.println("Enter 1 to add more courses : \n" +
                        "Enter 0 to add stop adding courses : \n");
                if(Integer.parseInt(reader.readLine())==0)flag =false;
            }
            teacher.setCourseSet(courseSet);
            session.saveOrUpdate(teacher);
            session.getTransaction().commit();
            System.out.println("Teacher courses updated successfully !!");
        }
    }

    @Override
    public void showTeacherAndTheirCourses() throws IOException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("Enter Teacher Id : ");
        teacher = session.get(Teacher.class,Integer.parseInt(reader.readLine()));
        if(teacher!=null)System.out.println(teacher);
        else System.out.println("Teacher Not found !");
    }

    @Override
    public void deleteTeacher() throws IOException {
        System.out.println("Enter teacher ID to delete Teacher : ");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        teacher = session.get(Teacher.class, Integer.parseInt(reader.readLine()));
        if (teacher != null) {
            session.delete(teacher);
            session.getTransaction().commit();
            System.out.println("Teacher deleted successfully ");
        }
        else System.out.println("Teacher not found !!");
    }

    @Override
    public void deleteCourses() {

    }

    @Override
    public void updateCourse() {

    }

    @Override
    public void updateTeacher() {

    }
}
