package com.devansh.student.service;

import com.devansh.student.entities.Teacher;
import org.springframework.http.ResponseEntity;

public interface TeacherService {
    ResponseEntity addTeacher(Teacher teacher);
}
