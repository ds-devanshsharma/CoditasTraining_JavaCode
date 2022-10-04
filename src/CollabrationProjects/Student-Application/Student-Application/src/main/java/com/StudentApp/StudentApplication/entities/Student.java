package com.StudentApp.StudentApplication.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id@Column(name = "E_ID")
    public int enrollmentNumber;
    @Column(name = "F_NAME")
    private String firstName ;
    private String lastName ;

    private String gender ;
    private String stream ;
    private float rating ;
    private Date dob ;
//    @OneToOne
//    private Address address ;


    public int getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(int enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "enrollmentNumber=" + enrollmentNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", stream='" + stream + '\'' +
                ", rating=" + rating +
                ", dob=" + dob +
                '}';
    }
}
