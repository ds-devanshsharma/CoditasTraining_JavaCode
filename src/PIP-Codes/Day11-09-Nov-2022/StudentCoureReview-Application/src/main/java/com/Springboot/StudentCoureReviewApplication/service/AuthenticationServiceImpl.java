package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.dto.request.LoginDto;
import com.Springboot.StudentCoureReviewApplication.dto.request.SignUpDto;
import com.Springboot.StudentCoureReviewApplication.entities.LoginEntity;
import com.Springboot.StudentCoureReviewApplication.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    AuthenticationRepository authenticationRepository;

    @Override
    public LoginEntity signUp(SignUpDto signUp) {
        if(signUp.getLoginRole().equalsIgnoreCase("admin")) return null;
        LoginEntity registerUser = new LoginEntity();
        registerUser.setLoginEmail(signUp.getLoginEmail());
        registerUser.setLoginPassword(signUp.getLoginPassword());
        registerUser.setLoginRole(signUp.getLoginRole());
        return authenticationRepository.save(registerUser);
    }

    @Override
    public int login(LoginDto loginDto) {
        LoginEntity login = authenticationRepository.findById(loginDto.getUsername()).orElse(null);
        if(login == null)return 1;
        else if (!login.getLoginPassword().equals(loginDto.getLoginPassword())) return 2;
        else if(login.getLoginRole().equalsIgnoreCase("admin")) return 3;
        else return 4;
    }
}
