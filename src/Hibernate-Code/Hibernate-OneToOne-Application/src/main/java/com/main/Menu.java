package com.main;

import com.BookDAO.BookDAOImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    BookDAOImplementation implementation = new BookDAOImplementation();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    void menu() throws IOException {
        while(true){
            System.out.println("ENTER 1 FOR ADD BOOK \n" +
                    "ENTER 2 TO FETCH ALL BOOK \n" +
                    "ENTER 3 TO FETCH BOOK BY ID \n" +
                    "ENTER 4 TO DELETE BOOK \n" +
                    "ENTER 5 TO UPDATE BOOK \n" +
                    "ENTER 0 TO EXIT !! \n");
            switch(Integer.parseInt(reader.readLine())){
                case 1 :
                    implementation.insertBook();
                    break;
                case 2 :
                    implementation.fetchAllBook();
                    break;
                case 3 :
                    System.out.println("ENTER BOOK-ID TO FETCH : \n");
                    implementation.fetchBookByID(Integer.parseInt(reader.readLine()));
                    break;
                case 4 :
                    System.out.println("ENTER BOOK-ID TO DELETE : \n");
                    implementation.deleteBook(Integer.parseInt(reader.readLine()));
                    break;
                case 5 :
                    System.out.println("ENTER BOOK-ID TO UPDATE BOOK : \n");
                    implementation.updateBook(Integer.parseInt(reader.readLine()));
                    break;
                case  0:
                    System.out.println("LOGGED OUT SUCCESSFULLY !! ");
                    System.exit(1);
            }
        }
    }
}
