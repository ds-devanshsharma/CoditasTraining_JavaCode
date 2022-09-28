package com.main;

import com.bean.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainApplication {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int check=0;
        Query query;
        //hibernate: Architecture
        Configuration configuration = new Configuration().configure("hibernate.config.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
//This is only for taking input form user setting it into employee Object ----> then session.save();
//        Employee employee = new Employee();
//        System.out.println("EMPLOYEE SYSTEM !!");
//        System.out.println("ENTER EMPLOYEE ID : ");employee.setEmpID(Integer.parseInt(reader.readLine()));
//        System.out.println("ENTER NAME : ");employee.setName(reader.readLine());
//        System.out.println("ENTER DESIGNATION : ");employee.setDesignation(reader.readLine());
//        System.out.println("ENTER SALARY : ");employee.setSalary(Float.parseFloat(reader.readLine()));
//        System.out.println("ENTER CITY : ");employee.setCity(reader.readLine());

        //save -> insert
//        check = (int)session.save(employee);
        // 1 - counting number of record
        List<Integer> list = session.createQuery("from EMPLOYEETABLE").list();

        if(!list.isEmpty()){
            transaction.commit();
//            System.out.println("RECORD ADDED SUCCESSFULLY !!");
            System.out.println("COUNT OF RECORDS : "+list.size());
        }
        else{
            System.out.println("TRY AGAIN !!");
        }
    }
}
