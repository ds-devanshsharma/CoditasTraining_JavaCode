package com.main;

import com.bean.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Student student;
    public static void main(String[] args) throws IOException {

        // hibernate:Architecture
        Configuration configuration = new Configuration()
                .configure("hibernate.config.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //setting values
        student = new Student();
        System.out.println("ENTER ID :");student.setId(Integer.parseInt(reader.readLine()));
        System.out.println("ENTER NAME :");student.setName(reader.readLine());
        System.out.println("ENTER BATCH-NAME :");student.setBatch(reader.readLine());
        System.out.println("ENTER RATING : ");student.setRating(Float.parseFloat(reader.readLine()));



        //save session
        int check = (int)session.save(student);
        if(check!=0)
        {
            transaction.commit();
            System.out.println("Record Added Successfully !");
        }else{
            System.out.println("Try Again !!");
        }
    }
}
