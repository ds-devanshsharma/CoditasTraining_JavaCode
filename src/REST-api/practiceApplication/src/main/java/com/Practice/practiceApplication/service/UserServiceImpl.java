package com.Practice.practiceApplication.service;

import com.Practice.practiceApplication.entities.User;
import com.Practice.practiceApplication.exception.IncorrectPasswordException;
import com.Practice.practiceApplication.exception.UserNotFoundException;
import com.Practice.practiceApplication.model.request.LoginDto;
import com.Practice.practiceApplication.model.request.SignupDto;
import com.Practice.practiceApplication.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public User userSignup(SignupDto signupDto) {
        return  userRepository.save(this.mapper.map(signupDto,User.class));
    }

    @Override
    public int userLogin(LoginDto loginDto) {
        User user = userRepository.findById(loginDto.getUsername()).orElse(null);
        if(user == null)
            throw new UserNotFoundException();
        else if (!user.getPassword().equals(loginDto.getPassword()))
            throw new IncorrectPasswordException();
        else
            return 1;
    }
}
