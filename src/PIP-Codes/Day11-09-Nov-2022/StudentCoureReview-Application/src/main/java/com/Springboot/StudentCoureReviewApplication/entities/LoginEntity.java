package com.Springboot.StudentCoureReviewApplication.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Login_info_table")
public class LoginEntity {
    @Id
    @Column(name = "username")
    private String loginEmail;
    @Column(nullable = false ,name = "password")
    private String loginPassword;
    @Column(nullable = false ,name = "role")
    private String loginRole;
}
