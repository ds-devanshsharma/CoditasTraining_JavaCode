package com.bean;

public class Tutor {
    private int tutorID;
    private String tutorName;

    @Override
    public String toString() {
        return "Tutor{" +
                "tutorID=" + tutorID +
                ", tutorName='" + tutorName + '\'' +
                '}';
    }

    public int getTutorID() {
        return tutorID;
    }

    public void setTutorID(int tutorID) {
        this.tutorID = tutorID;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }
}
