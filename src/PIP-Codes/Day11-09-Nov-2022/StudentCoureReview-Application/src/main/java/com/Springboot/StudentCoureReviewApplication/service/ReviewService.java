package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.dto.request.RemoveReviewDto;
import com.Springboot.StudentCoureReviewApplication.dto.request.ReviewDto;
import com.Springboot.StudentCoureReviewApplication.entities.ReviewEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService {
    int addReview(ReviewDto review);
    boolean removeReview(RemoveReviewDto removeReviewDto);
    List<ReviewEntity> showReviewGivenByStudent(Long studentId);
}
