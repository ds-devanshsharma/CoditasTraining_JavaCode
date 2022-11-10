package com.Springboot.Voting.Application.controller;

import com.Springboot.Voting.Application.dto.request.UserRegisterDto;
import com.Springboot.Voting.Application.entities.User;
import com.Springboot.Voting.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;

    @PostMapping("/registerUser")
    ResponseEntity registerUserController(@RequestBody  UserRegisterDto userDto){
        try{
            HashMap<String,String> map = new HashMap<>();
            User registerUser = userService.registerUser(userDto);
            if(registerUser !=null )
                return new ResponseEntity(registerUser, HttpStatus.CREATED);
            else
                return new ResponseEntity("User Not Registered ! Maybe Your Age < 18 ",HttpStatus.NOT_ACCEPTABLE);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
