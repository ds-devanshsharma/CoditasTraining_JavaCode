package com.main;

import com.bean.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        //hibernate logic: Architechture
        Configuration configuration =  new Configuration()
                .configure("hibernate.config.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Book bookBean = new Book();
        System.out.println("Enter BookId :");
        bookBean.setId(Integer.parseInt(reader.readLine()));
        System.out.println("Enter BookName :");
        bookBean.setBookName(reader.readLine());
        System.out.println("Enter BookAuthor : ");
        bookBean.setAuthorName(reader.readLine());
        System.out.println("Enter Price : ");
        bookBean.setPrice(Float.parseFloat(reader.readLine()));
        System.out.println("Enter BookRating :");
        bookBean.setRating(Integer.parseInt(reader.readLine()));
        int check =(int)session.save(bookBean);
        if(check !=0)
            transaction.commit();
        else
            System.out.println("TryAgain !");
    }
}
