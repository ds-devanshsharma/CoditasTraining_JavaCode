package com.bookMyEvent.BookMyEventApplication.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Admin_table")
@Data
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId ;
    @Column(nullable = false)
    private String adminName ;
    @Column(nullable = false)
    private String adminEmail;
}
