package com.Springboot.StudentCoureReviewApplication.dto.request;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String loginPassword;
}
