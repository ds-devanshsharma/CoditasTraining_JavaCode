package com.main;

import com.bean.Employee;
import com.bean.FullTimeEmployee;
import com.bean.PartTimeEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee(101,"DEVANSH");
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(102,"Usman",45000,12,2000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(103,"RT",10,3000);
        session.save(employee);
        session.save(fullTimeEmployee);
        session.save(partTimeEmployee);
        transaction.commit();
    }
}
