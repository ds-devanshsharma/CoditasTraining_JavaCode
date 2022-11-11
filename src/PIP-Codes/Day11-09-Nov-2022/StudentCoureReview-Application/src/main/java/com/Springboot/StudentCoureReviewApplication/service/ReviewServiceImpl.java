package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.dto.request.RemoveReviewDto;
import com.Springboot.StudentCoureReviewApplication.dto.request.ReviewDto;
import com.Springboot.StudentCoureReviewApplication.entities.CourseEntity;
import com.Springboot.StudentCoureReviewApplication.entities.ReviewEntity;
import com.Springboot.StudentCoureReviewApplication.entities.StudentEntity;
import com.Springboot.StudentCoureReviewApplication.repository.CourseRepository;
import com.Springboot.StudentCoureReviewApplication.repository.ReviewRepository;
import com.Springboot.StudentCoureReviewApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public int addReview(ReviewDto review) {
        StudentEntity student =null;
        CourseEntity course =null;
        try {
            student = studentRepository.findById(review.getStudentId()).get();
            course = courseRepository.findById(review.getCourseId()).get();
            //checking student registered in that course or not
            if (course.getStudentList().contains(student)) {
                ReviewEntity reviewEntity = new ReviewEntity();
                reviewEntity.setReviewRating(review.getReviewRating());
                reviewEntity.setDescription(review.getReviewDescription());
                reviewEntity.setCourse(course);
                reviewEntity.setStudent(student);
                course.getReviewList().add(reviewEntity);
//        already set =>    course.getStudentList().add(student);
                student.getReviewList().add(reviewEntity);
                reviewRepository.save(reviewEntity);
                studentRepository.save(student);
                courseRepository.save(course);
            } else return 3;
        }finally {
            if (student == null) return 1;
            if (course == null) return 2;

        }
        return 0;
    }

    @Override
    public boolean removeReview(RemoveReviewDto removeReview) {
        ReviewEntity reviewFound = reviewRepository.findById(removeReview.getReviewId()).get();
        if(reviewFound != null){
            reviewRepository.delete(reviewFound);
            return true;
        }
        return false;
    }

    @Override
    public List<ReviewEntity> showReviewGivenByStudent(Long studentId) {
        return reviewRepository.getReviewByStudentId(studentId);
    }
}
