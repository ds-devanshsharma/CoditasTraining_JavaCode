package com.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int studentID;
    String studentName;
    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "Student_Subject", joinColumns = @JoinColumn(name = "student_id"),
//    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    List<Subject> subjectList;

    public List<Marks> getMarks() {
        return marks;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }

    @OneToMany(mappedBy = "student")
    List<Marks> marks;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
