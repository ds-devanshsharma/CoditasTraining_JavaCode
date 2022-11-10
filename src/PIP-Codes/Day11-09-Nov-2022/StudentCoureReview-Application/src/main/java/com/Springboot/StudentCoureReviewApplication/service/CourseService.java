package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.entities.CourseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    CourseEntity registerCourse(CourseEntity Course);
    CourseEntity updateCourse(CourseEntity Course);
    boolean deleteCourse(Long CourseId);
    List<CourseEntity> showCourseList();
}
