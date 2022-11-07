package com.devansh.student.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;
}