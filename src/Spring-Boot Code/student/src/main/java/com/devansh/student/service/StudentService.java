package com.devansh.student.service;

import com.devansh.student.entities.Student;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);
    public List<Student> getStudents();

    boolean deleteStudent(int studentId);

    Student updateStudent(Student student);
}
