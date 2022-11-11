package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.dto.request.UpdateStudentDto;
import com.Springboot.StudentCoureReviewApplication.entities.StudentEntity;
import org.springframework.stereotype.Service;
import java.util.List;


public interface StudentService {
    StudentEntity registerStudent(StudentEntity student);
    StudentEntity updateStudent(UpdateStudentDto student);
    boolean deleteStudent(Long studentId);
    List<StudentEntity> showStudentList();
    int buyCourses(Long studentId , Long courseId);
}
