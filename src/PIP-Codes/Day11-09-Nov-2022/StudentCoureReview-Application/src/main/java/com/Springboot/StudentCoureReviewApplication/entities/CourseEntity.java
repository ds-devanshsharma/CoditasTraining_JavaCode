package com.Springboot.StudentCoureReviewApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "Student_Course_table",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "studentId"))
    private List<StudentEntity> studentList ;

    @OneToMany(mappedBy = "course" ,fetch = FetchType.LAZY)
    private List<ReviewEntity> reviewList ;
}
