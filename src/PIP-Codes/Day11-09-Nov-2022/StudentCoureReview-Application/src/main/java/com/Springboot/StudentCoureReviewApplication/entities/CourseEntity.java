package com.Springboot.StudentCoureReviewApplication.entities;

import lombok.Data;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Course_table")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseId")
    private Long courseId;
    @Column(nullable = false,name="CourseName")
    private String courseName;
    @Column(nullable = false,name = "CoursePrice")
    private Double coursePrice;

    @ManyToMany
    @JoinTable(name = "Student_Course_table",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "courseId"))
    private List<StudentEntity> studentList ;
    @OneToMany(mappedBy = "course")
    private List<ReviewEntity> reviewList ;
}
