package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.dto.request.ReviewDto;
import com.Springboot.StudentCoureReviewApplication.entities.ReviewEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    ReviewEntity addReview(ReviewDto review);
    boolean removeReview(Long reviewId);
    List<ReviewEntity> showReviewGivenByStudent(Long studentId);
}
