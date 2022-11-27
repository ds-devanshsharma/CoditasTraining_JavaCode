package com.Practice.practiceApplication.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("USERNAME NOT FOUND !");
    }
}
