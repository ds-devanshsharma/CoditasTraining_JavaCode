package com.Collabration.FirstProject.FirstProject.Entities;

public class CoditasIntern {
    private int internID;
    private String internName;
    private String city;
    private String batchName;
    private float rating;
    private String imgPath;

    public CoditasIntern(int internID,String imgPath, String internName, String city, String batchName, float rating) {
        this.internID = internID;
        this.internName = internName;
        this.city = city;
        this.batchName = batchName;
        this.rating = rating;
        this.imgPath = imgPath;
    }

    public CoditasIntern() {

    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return
                "[ internID=" + internID +
                ", internName='" + internName + '\'' +
                ", city='" + city + '\'' +
                ", batchName='" + batchName + '\'' +
                ", rating=" + rating +
                "path = "+imgPath+ " ]";
    }
}
