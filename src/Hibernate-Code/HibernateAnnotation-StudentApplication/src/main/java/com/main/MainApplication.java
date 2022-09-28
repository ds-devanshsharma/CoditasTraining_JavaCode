package com.main;

import com.bean.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
    //hibernate :Architecture
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory =  configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //setting values
        Student student = new Student();
        System.out.println("ENTER ID ");student.setId(Integer.parseInt(reader.readLine()));
        System.out.println("ENTER NAME : ");student.setName(reader.readLine());
        System.out.println("ENTER CITY : ");student.setCity(reader.readLine());
        System.out.println("ENTER RATING : ");student.setRating(Float.parseFloat(reader.readLine()));
        System.out.println("ENTER STREAM : ");student.setBatch(reader.readLine());
        int check = (int)session.save(student);
        if(check!=0){
            transaction.commit();
            System.out.println("RECORD ADDED SUCCESSFULLY !");
        }
        else{
            System.out.println("TRY AGAIN !");
        }
    }
}
