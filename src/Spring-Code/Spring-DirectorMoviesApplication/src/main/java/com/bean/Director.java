package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
public class Director {
    private String name ;
    @Autowired
    public Set<Movie> movies;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private Properties properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return
                "[ name='" + name +
                ", movies=" + movies +" ]";
    }
}
