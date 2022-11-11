package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.dto.request.LoginDto;
import com.Springboot.StudentCoureReviewApplication.dto.request.SignUpDto;
import com.Springboot.StudentCoureReviewApplication.entities.LoginEntity;

public interface AuthenticationService {
    LoginEntity signUp(SignUpDto signUp);
    int login(LoginDto loginDto);
}
