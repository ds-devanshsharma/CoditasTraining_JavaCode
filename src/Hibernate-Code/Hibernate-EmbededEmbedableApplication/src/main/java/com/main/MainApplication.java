package com.main;

import com.entities.Address;
import com.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //
        Address address =new Address();
        address.setFlatNo(204);
        address.setStreet("MG ROAD ");
        //
        Employee employee = new Employee();
        employee.setUserName("Devansh");
//        employee.setAddress(address);
        session.save(employee);
        session.getTransaction().commit();
    }
}
