package com.Practice.practiceApplication.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "user_info")
public class User {
    @Id
    @Email(message = "INVALID EMAIL !")
    @NotEmpty(message = "EMAIL CANT BE EMPTY !")
    private String username;

    @Size(min=8 ,max =12 , message = "PASSWORD IS TOO WEAK! ")
    @NotEmpty(message = "PASSWORD CAN'T BE EMPTY !")
    private String password;
}
