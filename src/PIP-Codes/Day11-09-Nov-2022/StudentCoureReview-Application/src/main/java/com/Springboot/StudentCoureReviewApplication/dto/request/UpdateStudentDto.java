package com.Springboot.StudentCoureReviewApplication.dto.request;

import lombok.Data;

@Data
public class UpdateStudentDto {
    private Long studentId;
    private String studentName;
    private String studentCity;
    private String studentEmail;
}
