package com.Practice.practiceApplication.exception;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(){
        super("INVALID PASSWORD !");
    }
}