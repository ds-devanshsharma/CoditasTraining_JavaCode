package com.Springboot.StudentCoureReviewApplication.dto.request;

import lombok.Data;

@Data
public class ReviewDto {
    private Long courseId;
    private Long studentId;
    private Double reviewRating;
    private String reviewDescription;
}
