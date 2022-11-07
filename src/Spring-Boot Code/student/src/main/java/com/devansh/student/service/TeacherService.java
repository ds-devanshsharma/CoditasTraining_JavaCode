package com.devansh.student.service;
import com.devansh.student.entities.Teacher;
import org.springframework.http.ResponseEntity;

public interface TeacherService {
    ResponseEntity addTeacher(Teacher Teacher);
    ResponseEntity getTeachers();

    ResponseEntity deleteTeacher(int TeacherId);

    ResponseEntity updateTeacher(Teacher Teacher);
}
