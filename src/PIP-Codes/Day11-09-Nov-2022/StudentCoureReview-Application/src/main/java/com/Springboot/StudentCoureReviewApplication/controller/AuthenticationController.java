package com.Springboot.StudentCoureReviewApplication.controller;

import com.Springboot.StudentCoureReviewApplication.dto.request.LoginDto;
import com.Springboot.StudentCoureReviewApplication.dto.request.SignUpDto;
import com.Springboot.StudentCoureReviewApplication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signUp")
    ResponseEntity signUpController(@RequestBody SignUpDto signUpDto){
        try{
            if(authenticationService.signUp(signUpDto) != null)
                return new ResponseEntity("USER REGISTERED !",HttpStatus.CREATED);
            else
                return new ResponseEntity("NO MORE ADMIN ALLOWED ! ",HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity("DUPLICATE ENTRY FOUND !",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    ResponseEntity loginController(@RequestBody LoginDto loginDto){
        try{
            int status = authenticationService.login(loginDto);
            if(status == 1)
                return new ResponseEntity("WRONG USERNAME !" ,HttpStatus.NOT_FOUND);
            else if (status == 2)
                return new ResponseEntity("WRONG PASSWORD !",HttpStatus.UNAUTHORIZED);
            else if (status == 3)
                return new ResponseEntity("LOGGED IN AS ADMIN !",HttpStatus.OK);
            else
                return new ResponseEntity("LOGGED IN AS USER !",HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
