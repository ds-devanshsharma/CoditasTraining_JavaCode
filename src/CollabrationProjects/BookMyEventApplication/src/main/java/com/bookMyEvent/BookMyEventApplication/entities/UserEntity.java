package com.bookMyEvent.BookMyEventApplication.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User_table")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String role;
}
