package com.BookDAO;

import com.bean.Author;
import com.bean.Book;
import com.utils.SessionFactoryMaker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookDAOImplementation implements BookDAO{
    Book book;
    Author author;
    int check1 ,check2= 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void insertBook() throws IOException {

        Session session = SessionFactoryMaker.sessionFactoryProvider().openSession();
        Transaction transaction=session.beginTransaction();
        book = getBook();
        session.save(book);
        session.save(author);
        transaction.commit();
        System.out.println("RECORD ADDED SUCCESSFULLY !! ");

    }
    Book getBook() throws IOException {
        book = new Book();
//        System.out.println("ENTER BOOK-ID : ");
//        book.setBookID(Integer.parseInt(reader.readLine()));
        System.out.println("ENTER BOOK-NAME : ");
        book.setBookName(reader.readLine());
        System.out.println("ENTER BOOK-PRICE : ");
        book.setPrice(Float.parseFloat(reader.readLine()));
        author = getAuthorData();
        book.setAuthor(author);
        return book;
    }
    Author getAuthorData() throws IOException {
        author = new Author();
        System.out.println("ENTER AUTHOR ID :");
        author.setAuthorID(Integer.parseInt(reader.readLine()));
        System.out.println("ENTER AUTHOR NAME : ");
        author.setAuthorName(reader.readLine());
        return author;
    }

    @Override
    public void fetchAllBook() {
        System.out.println("BOOK RECORDS : ");
        Session session = SessionFactoryMaker.sessionFactoryProvider().openSession();
        session.createQuery("from Book").list().stream().forEach(System.out::println);
   }

    @Override
    public void deleteBook(int bookID) {
        Session session = SessionFactoryMaker.sessionFactoryProvider().openSession();
        session.beginTransaction();
        session.delete(session.get(Book.class,bookID));
        session.getTransaction().commit();
        System.out.println("RECORD DELETED SUCCESSFULLY !!");
    }

    @Override
    public void updateBook(int bookID) throws IOException {
        Session session = SessionFactoryMaker.sessionFactoryProvider().openSession();
        session.beginTransaction();
        book = session.get(Book.class,bookID);
        Author author1 = book.getAuthor();
        System.out.println("ENTER AUTHOR NAME TO UPDATE  :");
        author1.setAuthorName(reader.readLine());
        book.setAuthor(author1);
        session.getTransaction().commit();
        System.out.println("RECORD UPDATED SUCCESSFULLY !!");
    }

    @Override
    public void fetchBookByID(int bookID) {
        Session session = SessionFactoryMaker.sessionFactoryProvider().openSession();
        session.beginTransaction();
        book = session.get(Book.class,bookID);
        System.out.println("RECORD OF ID :  "+bookID +"\n");
        System.out.println("BOOK_ID "+book.getBookID() +"\n" +
                "Book-Name : "+book.getBookName()+"\n" +
                "Book-Author : "+book.getAuthor().getAuthorName());
    }
}
