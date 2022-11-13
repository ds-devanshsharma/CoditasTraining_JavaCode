package com.Springboot.TestApplication.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table(name = "Course_table")
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    @Column(nullable = false, name = "courseName")
    private String courseName;

    @Column(nullable = false ,name = "courseFee")
    private double courseFees;

    @OneToMany(mappedBy = "course" ,cascade = CascadeType.PERSIST,
    fetch = FetchType.LAZY)
    private List<Student> studentList ;
}
