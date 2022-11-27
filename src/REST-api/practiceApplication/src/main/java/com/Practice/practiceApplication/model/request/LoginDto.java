package com.Practice.practiceApplication.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginDto {
    private String username;
    private String password;
}
