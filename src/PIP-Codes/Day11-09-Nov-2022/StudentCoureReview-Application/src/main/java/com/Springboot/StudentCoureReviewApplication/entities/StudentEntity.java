package com.Springboot.StudentCoureReviewApplication.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Student_table")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long studentId;
    @Column(nullable = false,name="studentName")
    private String studentName;
    @Column(nullable = false,name = "studentCity")
    private String studentCity;
    @Column(nullable = false,unique = true,name = "studentEmail")
    private String studentEmail;

    @ManyToMany(mappedBy = "studentList")
    private List<CourseEntity> courseList =new ArrayList<>();

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<ReviewEntity> reviewList= new ArrayList<>();
}
