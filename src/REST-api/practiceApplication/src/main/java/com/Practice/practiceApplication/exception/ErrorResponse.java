package com.Practice.practiceApplication.exception;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ErrorResponse {
    private LocalDate date ;
    private String message;

    public ErrorResponse(LocalDate date, String message) {
        this.date = date;
        this.message = message;
    }
}
