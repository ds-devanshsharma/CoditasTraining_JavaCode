package com.DAO;

import com.bean.Student;

import java.util.List;

public interface StudentDAO {
    int insertStudent(Student student);
    int updateStudent();
    int deleteStudent();
    List<Student> fetchStudent();
}
