package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.entities.StudentEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentService {
    StudentEntity registerStudent(StudentEntity student);
    StudentEntity updateStudent(StudentEntity student);
    boolean deleteStudent(Long studentId);
    List<StudentEntity> showStudentList();
    boolean buyCourses(Long studentId , Long courseId);
}
