package com.Practice.practiceApplication.service;

import com.Practice.practiceApplication.entities.User;
import com.Practice.practiceApplication.model.request.LoginDto;
import com.Practice.practiceApplication.model.request.SignupDto;

public interface UserService {
    User userSignup(SignupDto signupDto);
    int  userLogin(LoginDto loginDto);
}
