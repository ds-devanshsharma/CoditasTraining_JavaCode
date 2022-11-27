package com.Practice.practiceApplication.controller;

import com.Practice.practiceApplication.entities.User;
import com.Practice.practiceApplication.model.request.LoginDto;
import com.Practice.practiceApplication.model.request.SignupDto;
import com.Practice.practiceApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins={"*"} , maxAge = 4800,allowCredentials = "false")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    ResponseEntity userSignupController(@Valid @RequestBody SignupDto signupDto){
        User user = userService.userSignup(signupDto);
        if(user != null )
            return new ResponseEntity("USER REGISTERED !" , HttpStatus.CREATED);
        else
            return new ResponseEntity("SIGN-UP FAILED !" ,HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/login")
    ResponseEntity userLoginController(@RequestBody LoginDto loginDto){
        int status  = userService.userLogin(loginDto);
        if(status == 1)
            return new ResponseEntity("LOGGED IN SUCCESSFULLY !" ,HttpStatus.OK);
        else
            return new ResponseEntity("WRONG PASSWORD !",HttpStatus.NOT_ACCEPTABLE);
    }
 }
