package com.devansh.student.service;

import com.devansh.student.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    ResponseEntity addStudent(Student student);
    ResponseEntity getStudents();

    ResponseEntity deleteStudent(int studentId);

    ResponseEntity updateStudent(Student student);
    ResponseEntity assignTeacherToStudent(int studentId ,int teacherId);
}
