package com.Practice.practiceApplication.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SignupDto {
    @Email(message = "INVALID EMAIL !")
    @NotEmpty(message = "USERNAME CANT BE EMPTY !")
    private String username;

    @Size(min=8 ,max =12 , message = "PASSWORD IS TOO WEAK ! ")
    @NotEmpty(message = "PASSWORD CAN'T BE EMPTY !")
    private String password;
}