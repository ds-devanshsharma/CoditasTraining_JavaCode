package com.SecondProject.CricketProject.Entities.Pojo;

public class Award {
    private int year;
    private String awardName;

    @Override
    public String toString() {
        return
                "[ Year =" + year +
                ", awardName='" + awardName + " ]";
    }

    public int getYear() {
        return year;
    }

    public void setYear(int date) {
        this.year = date;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
