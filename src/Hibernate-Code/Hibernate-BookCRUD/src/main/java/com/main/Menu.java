package com.main;

import com.DAO.BookCRUDImplementation;
import com.bean.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Book book;
    BookCRUDImplementation bookCRUDImplementation = new BookCRUDImplementation();
    String property;
    public void menu() throws IOException {
        while(true){
            System.out.println("ENTER 1 FOR INSERT BOOK ! \n" +
                    "ENTER 2 FOR FETCH ALL BOOK !\n" +
                    "ENTER 3 FOR DELETE BOOK !\n" +
                    "ENTER 4 FOR UPDATE BOOK !\n" +
                    "ENTER 5 FOR FETCH byID !\n" +
                    "ENTER 6 FOR FETCH BY RESTRICTION !\n" +
                    "ENTER 7 FOR FETCH ORDER BY !\n" +
                    "ENTER 8 FOR FETCH BASED ON PROJECTION !\n" +
                    "ENTER 0 FOR EXIT ! ");
            switch(Integer.parseInt(reader.readLine())){
                case 1 :
                    book = new Book();
                    System.out.println("Enter bookID : ");book.setBookID(Integer.parseInt(reader.readLine()));
                    System.out.println("Enter bookName :");book.setBookName(reader.readLine());
                    System.out.println("Enter AuthorName :");book.setAuthorName(reader.readLine());
                    System.out.println("Enter BookRating : ");book.setRating(Float.parseFloat(reader.readLine()));
                    System.out.println("Enter Book Price : ");book.setPrice(Float.parseFloat(reader.readLine()));
                    bookCRUDImplementation.insertBook(book);
                    break;
                case 2 :
                    bookCRUDImplementation.fetchBook();
                    break;
                case 3 :
                    System.out.println("Enter Book ID for Delete : ");
                    bookCRUDImplementation.deleteBook(Integer.parseInt(reader.readLine()));
                    break;
                case 4 :
                    System.out.println("Enter BookID for Update : ");
                    int bookID = Integer.parseInt(reader.readLine());
                    System.out.println("Enter Book new Price :");
                    float price = Float.parseFloat(reader.readLine());
                    bookCRUDImplementation.updateBook(bookID,price);
                    break;
                case 5 :
                    System.out.println("Enter bookID for fetch :");
                    bookCRUDImplementation.fetchBookByID(Integer.parseInt(reader.readLine()));

                    break;
                case 6 :
                    System.out.println("Enter restriction price : ");
                    bookCRUDImplementation.fetchByRestriction(Float.parseFloat(reader.readLine()));
                    break;
                case 7 :
                    System.out.println("Which Order ?? asc /desc ");
                    String order= reader.readLine();
                    System.out.println("On Which Property bookName / authorName / price / rating");
                     property = reader.readLine();
                    bookCRUDImplementation.fetchByOrder(order,property);
                    break;
                case 8 :
                    System.out.println("Enter property for projection ! ");
                    System.out.println("On Which Property bookName / authorName / price / rating");
                    property = reader.readLine();
                    bookCRUDImplementation.fetchByProjection(property);
                    break;
                case 0 :
                    System.out.println("LOGGED OUT SUCCESSFULLY !!");
                    System.exit(1);
            }
        }
    }
}

