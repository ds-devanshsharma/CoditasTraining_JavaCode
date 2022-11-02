package com.jpa.hibernate.SpringBootHibernateJPA.entities;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int studentId;
    @Column(nullable = false)
    private String studentName;
    @OneToOne
    private Passport passport;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
