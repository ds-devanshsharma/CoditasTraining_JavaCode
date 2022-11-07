package com.jpa.hibernate.SpringBootHibernateJPA.service;

import org.springframework.http.ResponseEntity;

public interface StudentService {
     void retrieveStudentAndCourses(int studentId);
     void insertStudentAndCourse();
     void addStudentToCourse(int courseId);
     void addCourseToStudent(int studentId);
}
