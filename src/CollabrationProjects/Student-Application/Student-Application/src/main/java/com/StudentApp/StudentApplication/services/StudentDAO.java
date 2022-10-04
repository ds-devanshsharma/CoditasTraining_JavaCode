package com.StudentApp.StudentApplication.services;

import com.StudentApp.StudentApplication.entities.Student;

import java.util.List;

public interface StudentDAO {
    void registerStudent(Student student);
    void deleteStudent(int id);
    List<Student> fetchAllStudent();
    Student fetchStudentById(int id);
    void updateStudent(Student student);
}
