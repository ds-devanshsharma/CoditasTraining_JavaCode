package com.bean;

public class Movie {
    private int movieID;
    private String movieName;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Movie(int movieID, String movieName) {
        this.movieID = movieID;
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieID=" + movieID +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
