package com.DAOAssest;

import com.bean.Laptop;
import com.bean.Student;
import com.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AssetOperationImpl implements AssetOperation {
    SessionFactory sessionFactory = SessionFactoryProvider.sessionFactoryProviderMethod();
    Transaction transaction;
    Laptop laptop;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Student student;
    @Override
    public void registerAsset() throws IOException {
        student = new Student();
        System.out.println("ENTER STUDENT ID : ");student.setStudentID(Integer.parseInt(reader.readLine()));
        System.out.println("ENTER STUDENT NAME : ");student.setStudentName(reader.readLine());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);

        laptop = new Laptop();
        System.out.println("ENTER LAPTOP ID : ");laptop.setLaptopID(Integer.parseInt(reader.readLine()));
        System.out.println("ENTER LAPTOP NAME : ");laptop.setLaptopName(reader.readLine());
        laptop.setStudent(student);
        session.save(laptop);
        session.getTransaction().commit();
        System.out.println("RECORD ADDED SUCCESSFULLY !! ");
    }

    @Override
    public void displayAsset() {
        Session  session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("from Laptop ").list().stream().forEach(System.out::println);
    }

    @Override
    public void deleteAsset() {

    }

    @Override
    public void updateAsset() {

    }

    @Override
    public void displayAssetById() {

    }
}
