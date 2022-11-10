package com.Springboot.StudentCoureReviewApplication.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Review_table")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId ;
    @Column(nullable = false , name = "reviewRating")
    private Double reviewRating;
    @Column(nullable = false, name = "reviewDescription")
    private String description;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private CourseEntity course;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity student;
}
