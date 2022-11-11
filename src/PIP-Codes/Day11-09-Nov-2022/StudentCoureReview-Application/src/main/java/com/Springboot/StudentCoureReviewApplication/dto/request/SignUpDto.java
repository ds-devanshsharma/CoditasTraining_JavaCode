package com.Springboot.StudentCoureReviewApplication.dto.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class SignUpDto {
    private String loginEmail;
    private String loginPassword;
    private String loginRole;
}
