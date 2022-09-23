package com.Collabration.FirstProject.FirstProject.Entities;

public class CoditasInternList {
    private int internID;
    private String internName;

    @Override
    public String toString() {
        return "CoditasInternList{" +
                "internID=" + internID +
                ", internName='" + internName + '\'' +
                '}';
    }

    public int getInternID() {
        return internID;
    }

    public void setInternID(int internID) {
        this.internID = internID;
    }

    public String getInternName() {
        return internName;
    }

    public void setInternName(String internName) {
        this.internName = internName;
    }
}
