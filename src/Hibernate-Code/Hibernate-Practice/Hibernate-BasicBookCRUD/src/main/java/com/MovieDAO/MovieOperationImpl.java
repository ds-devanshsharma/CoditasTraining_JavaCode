package com.MovieDAO;

import com.bean.Movie;
import com.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieOperationImpl implements MovieOperation{
    SessionFactory sessionFactory = SessionFactoryProvider.sessionFactoryProvider();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Movie movie;
    @Override
    public void addMovie() throws IOException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.getMovie());
        session.getTransaction().commit();
    }
    Movie getMovie() throws IOException {
        movie = new Movie();
        System.out.println("Enter movieID : ");movie.setMovieID(Integer.parseInt(reader.readLine()));
        System.out.println("Enter Movie name :");movie.setMovieName(reader.readLine());
        System.out.println("Enter Movie Rating : ");movie.setRating(Float.parseFloat(reader.readLine()));
        return movie;
    }
    @Override
    public void displayMovie() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("from Movie").list().stream().forEach(System.out::println);
    }

    @Override
    public void deleteMovie(int movieID) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Movie.class,movieID));
        session.getTransaction().commit();
        System.out.println("RECORD DELETED SUCCESFULLY !!");
    }

    @Override
    public void updateMovie(int movieID) throws IOException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        movie = session.byId(Movie.class).getReference(movieID);
        boolean flag = true;
        while(flag){
            System.out.println("While You want To Update !\n" +
                    "1 -MovieName : \n" +
                    "2- MovieRating : \n" +
                    "0- goBack \n");
            switch (Integer.parseInt(reader.readLine())){
                case 1 :
                    System.out.println("Enter new MovieName : ");
                    movie.setMovieName(reader.readLine());
                    System.out.println("MovieName Updated Successfully !! \n" +
                            movie);
                    break;
                case 2 :
                    System.out.println("Enter new Rating : ");
                    movie.setRating(Float.parseFloat(reader.readLine()));
                    System.out.println("Movie Rating Updated Successfully !!\n" +
                            movie);
                    break;
                default :
                    flag = false;
            }
        }
        session.getTransaction().commit();
    }

    @Override
    public void displayMovieById(int movieID) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        movie = session.get(Movie.class,movieID);
        System.out.println(movie);
    }
}
