package com.bean;

import java.util.Set;

public class Director {
    private int directorID;
    private String directorName;
    private Set<Movie> movieSet; // HAS-A

    @Override
    public String toString() {
        return "Director{" +
                "directorID=" + directorID +
                ", directorName='" + directorName + '\'' +
                ", movieSet=" + movieSet +
                '}';
    }

    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Set<Movie> getMovieSet() {
        return movieSet;
    }

    public void setMovieSet(Set<Movie> movieSet) {
        this.movieSet = movieSet;
    }
}
