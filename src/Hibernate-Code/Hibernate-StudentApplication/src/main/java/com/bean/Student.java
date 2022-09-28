package com.bean;

public class Student {
    private int id;
    private String name;
    private String batch;
    private float rating ;

    @Override
    public String toString() {
        return
                "[ id=" + id +
                ", name='" + name + '\'' +
                ", batch='" + batch + '\'' +
                ", rating=" + rating +" ]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
