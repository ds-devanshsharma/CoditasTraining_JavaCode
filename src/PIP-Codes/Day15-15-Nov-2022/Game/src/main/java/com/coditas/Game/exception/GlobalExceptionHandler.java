package com.coditas.Game.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<Object> gameNotFoundResponse(Exception exception , WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return handleExceptionInternal(exception,errorResponse,null, HttpStatus.NOT_FOUND,webRequest);
    }

    @ExceptionHandler(GameAlreadyStartedException.class)
    public ResponseEntity<Object> gameAlreadyStartedExceptionResponse(Exception exception , WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return handleExceptionInternal(exception,errorResponse,null, HttpStatus.NOT_FOUND,webRequest);
    }

    @ExceptionHandler(OutOfBoundaryException.class)
    public ResponseEntity<Object> outOfBoundaryExceptionResponse(Exception exception , WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return handleExceptionInternal(exception,errorResponse,null, HttpStatus.NOT_FOUND,webRequest);
    }

    @ExceptionHandler(PlayerAlreadyInGameException.class)
    public ResponseEntity<Object> playerAlreadyInGameExceptionResponse(Exception exception , WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return handleExceptionInternal(exception,errorResponse,null, HttpStatus.NOT_FOUND,webRequest);
    }

        @ExceptionHandler(PlayerIsNotInThatGameException.class)
    public ResponseEntity<Object> playerIsNotInThatGameExceptionResponse(Exception exception , WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return handleExceptionInternal(exception,errorResponse,null, HttpStatus.NOT_FOUND,webRequest);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<Object> playerNotFoundExceptionResponse(Exception exception , WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return handleExceptionInternal(exception,errorResponse,null, HttpStatus.NOT_FOUND,webRequest);
    }

    @ExceptionHandler(PositionOverlappedException.class)
    public ResponseEntity<Object> positionOverlappedExceptionResponse(Exception exception , WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return handleExceptionInternal(exception,errorResponse,null, HttpStatus.NOT_FOUND,webRequest);
    }
}
