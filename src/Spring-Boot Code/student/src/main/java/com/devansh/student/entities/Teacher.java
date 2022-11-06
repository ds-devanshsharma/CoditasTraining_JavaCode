package com.devansh.student.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private String teacherName;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;
}