package com.Springboot.Voting.Application.dto.request;

import lombok.Data;
@Data
public class UserRegisterDto {
    private String username;
    private Long age;
    private String password;
    private String contact;
}
