package com.devansh.student.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
    private List<Teacher> teachers;
}