package com.jpa.hibernate.SpringBootHibernateJPA.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    private int courseId ;
    private String courseName;
    @ManyToMany(cascade = CascadeType.PERSIST ,
    mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}