package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Laptop {
    @Id private int laptopID;
    private String laptopName;
    @OneToOne
    @JoinColumn(name = "studentID")
    private Student student;

    public int getLaptopID() {
        return laptopID;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopID=" + laptopID +
                ", laptopName='" + laptopName + '\'' +
                ", student=" + student +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setLaptopID(int laptopID) {
        this.laptopID = laptopID;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

}