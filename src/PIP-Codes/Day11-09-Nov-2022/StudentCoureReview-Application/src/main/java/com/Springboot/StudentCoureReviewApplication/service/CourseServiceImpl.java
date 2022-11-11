package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.entities.CourseEntity;
import com.Springboot.StudentCoureReviewApplication.repository.CourseRepository;
import com.Springboot.StudentCoureReviewApplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository CourseRepository;

    @Override
    public CourseEntity registerCourse(CourseEntity Course) {
        return CourseRepository.save(Course);
    }

    @Override
    public CourseEntity updateCourse(CourseEntity course) {
        CourseEntity updateCourse = CourseRepository.findById(course.getCourseId()).orElse(null);
        if(updateCourse != null){
            updateCourse.setCourseName(course.getCourseName());
            updateCourse.setReviewList(course.getReviewList());
            updateCourse.setCoursePrice(course.getCoursePrice());
            updateCourse.setStudentList(course.getStudentList());
            return CourseRepository.save(updateCourse);
        }
        return null;
    }

    @Override
    public boolean deleteCourse(Long CourseId) {
        CourseEntity deleteCourse = CourseRepository.findById(CourseId).orElse(null);
        if(deleteCourse !=null){
            CourseRepository.delete(deleteCourse);
            return true;
        }
        return false;
    }

    @Override
    public List<CourseEntity> showCourseList() {
        return CourseRepository.findAll();
    }
}
