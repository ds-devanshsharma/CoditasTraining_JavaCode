package com.service;

import com.entities.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface StudentService{
    String registerStudent(Student student);
    boolean deleteStudent(int id);
    List<Student> showStudentList();
    boolean  updateStudent(int id , HttpServletRequest req);
    Student showStudentBasedOnID(int id);
}
