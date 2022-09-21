package com.bean;

public class Movie {
    private String movieName;
    private int cost;
    private float rating;
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

    @Override
    public String toString() {
        return
                "[ movieName='" + movieName +
                ", cost=" + cost +
                ", rating=" + rating +" ]";
    }
}
