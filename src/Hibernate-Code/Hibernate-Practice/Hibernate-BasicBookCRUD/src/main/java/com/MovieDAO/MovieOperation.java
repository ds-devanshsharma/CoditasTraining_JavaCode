package com.MovieDAO;

import com.bean.Movie;

import java.io.IOException;

public interface MovieOperation {
    void addMovie() throws IOException;
    void displayMovie();
    void deleteMovie(int movieID);
    void updateMovie(int movieID) throws IOException;
    void displayMovieById(int movieID);
}
