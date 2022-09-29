package com.SecondProject.CricketProject.Entities;

public class Award {

    private String awardName;
    private String description;

    @Override
    public String toString() {
        return "Award{" +

                ", awardName='" + awardName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
