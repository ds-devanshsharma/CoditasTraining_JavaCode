package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.dto.request.ReviewDto;
import com.Springboot.StudentCoureReviewApplication.entities.CourseEntity;
import com.Springboot.StudentCoureReviewApplication.entities.ReviewEntity;
import com.Springboot.StudentCoureReviewApplication.entities.StudentEntity;
import com.Springboot.StudentCoureReviewApplication.repository.CourseRepository;
import com.Springboot.StudentCoureReviewApplication.repository.ReviewRepository;
import com.Springboot.StudentCoureReviewApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public HashMap<String ,String> addReview(ReviewDto review) {
        StudentEntity student = studentRepository.findById(review.getStudentId()).get();
        CourseEntity course = courseRepository.findById(review.getCourseId()).get();
        if(student!=null && course !=null){
            ReviewEntity reviewEntity = new ReviewEntity();
            reviewEntity.setReviewRating(review.getReviewRating());
            reviewEntity.setDescription(reviewEntity.getDescription());
            reviewEntity.setCourse(course);
            reviewEntity.setStudent(student);
            course.getReviewList().add(reviewEntity);
//            course.getStudentList().add(student);
            student.getReviewList().add(reviewEntity);
            courseRepository.save(course);
            studentRepository.save(student);
        }
        return null;
    }

    @Override
    public boolean removeReview(Long reviewId) {
        ReviewEntity review = reviewRepository.findById(reviewId).get();
        return false;
    }

    @Override
    public List<ReviewEntity> showReviewGivenByStudent(Long studentId) {
        return null;
    }
}
