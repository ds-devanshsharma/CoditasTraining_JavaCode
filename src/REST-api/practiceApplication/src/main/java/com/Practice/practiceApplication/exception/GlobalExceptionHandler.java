package com.Practice.practiceApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<Object> incorrectPasswordExceptionResponse(Exception exception, WebRequest webRequest) {
//        ErrorResponse errorResponse = new ErrorResponse(LocalDate.now(), exception.getMessage());
//        return handleExceptionInternal(exception, errorResponse, null, HttpStatus.NOT_ACCEPTABLE, webRequest);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentsNotValidException(MethodArgumentNotValidException exception, WebRequest webRequest) {
        Map<String, String> responseList = new HashMap<>();
        exception.getBindingResult().getAllErrors()
                .forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    responseList.put(fieldName, message);
                });
        return new ResponseEntity(responseList, HttpStatus.BAD_REQUEST);
    }
}