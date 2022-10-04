package com.main;
import com.MovieDAO.MovieOperation;
import com.MovieDAO.MovieOperationImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    MovieOperation operation = new MovieOperationImpl();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    void menu(){
            try {
                while (true) {
                    System.out.println("ENTER 1 FOR ADD MOVIE \n" +
                            "ENTER 2 TO FETCH ALL MOVIE \n" +
                            "ENTER 3 TO FETCH MOVIE BY ID \n" +
                            "ENTER 4 TO DELETE MOVIE \n" +
                            "ENTER 5 TO UPDATE MOVIE \n" +
                            "ENTER 0 TO EXIT !! \n");
                    switch (Integer.parseInt(reader.readLine())) {
                        case 1:
                            operation.addMovie();
                            break;
                        case 2:
                            operation.displayMovie();
                            break;
                        case 3:
                            System.out.println("ENTER BOOK-ID TO FETCH : \n");
                            operation.displayMovieById(Integer.parseInt(reader.readLine()));
                            break;
                        case 4:
                            System.out.println("ENTER BOOK-ID TO DELETE : \n");
                            operation.deleteMovie(Integer.parseInt(reader.readLine()));
                            break;
                        case 5:
                            System.out.println("ENTER BOOK-ID TO UPDATE BOOK : \n");
                            operation.updateMovie(Integer.parseInt(reader.readLine()));
                            break;
                        case 0:
                            System.out.println("LOGGED OUT SUCCESSFULLY !! ");
                            System.exit(1);
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                menu();
            }
    }
}




