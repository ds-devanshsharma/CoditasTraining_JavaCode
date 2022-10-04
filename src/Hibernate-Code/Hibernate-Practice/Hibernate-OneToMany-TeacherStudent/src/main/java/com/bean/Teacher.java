package com.bean;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Teacher {
    @Id

    private int teacherID;
    private String teacherName;
    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "teacher")
    private Set<Course> courseSet;

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID=" + teacherID +
                ", teacherName='" + teacherName + '\'' +
                ", courseSet=" + courseSet +
                '}';
    }
}
