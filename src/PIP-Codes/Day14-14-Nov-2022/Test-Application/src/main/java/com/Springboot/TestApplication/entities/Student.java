package com.Springboot.TestApplication.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false )
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_Id")
    private Course course;

}
