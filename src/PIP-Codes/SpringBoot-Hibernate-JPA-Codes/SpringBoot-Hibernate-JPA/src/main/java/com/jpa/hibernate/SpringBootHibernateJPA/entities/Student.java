package com.jpa.hibernate.SpringBootHibernateJPA.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    private int studentId;
    @Column(nullable = false)
    private String studentName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Student_Course_table",
    joinColumns = @JoinColumn(name = "student_Id"),
    inverseJoinColumns = @JoinColumn(name = "course_Id"))
    private List<Course> courses;
}