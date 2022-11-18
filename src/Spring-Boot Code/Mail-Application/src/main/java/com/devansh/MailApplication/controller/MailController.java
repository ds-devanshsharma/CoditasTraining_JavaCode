package com.devansh.MailApplication.controller;

import com.devansh.MailApplication.service.MailEntity;
import com.devansh.MailApplication.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @GetMapping("/sendMail")
    ResponseEntity sendController(@RequestBody MailEntity mailEntity){
        try {

            return new ResponseEntity(Optional.of(mailService.sendEmail(mailEntity)), HttpStatus.CREATED);
        }
        catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
