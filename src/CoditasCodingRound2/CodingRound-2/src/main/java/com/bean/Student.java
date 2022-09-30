package com.bean;

import java.util.HashMap;
import java.util.List;

public class Student {
    private int studentID;
    private String StudentName;
    private HashMap<Subject,Integer> listOfSubject;

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", StudentName='" + StudentName + '\'' +
                ", listOfSubject=" + listOfSubject +
                '}';
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public HashMap<Subject, Integer> getListOfSubject() {
        return listOfSubject;
    }

    public void setListOfSubject(HashMap<Subject, Integer> listOfSubject) {
        this.listOfSubject = listOfSubject;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
