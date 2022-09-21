package com.bean;

import java.util.List;

public class Movie {
    private String movieName;
    private int cost;
    private float rating;
    private List<String> cast;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return
                "[ movieName='" + movieName +
                ", cost=" + cost +
                ", rating=" + rating +
                ", cast=" + cast +" ]";
    }
}
