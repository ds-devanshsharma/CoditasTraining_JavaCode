package com.main;

import java.util.*;
import javax.persistence.*;

import com.entities.Employee;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Fetch {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory factory= configuration.buildSessionFactory();
        Session session=factory.openSession();

        //Hibernate Named Query
        TypedQuery query = session.getNamedQuery("findEmployeeByName");
        query.setParameter("name","amit");

        List<Employee> employees=query.getResultList();

        Iterator<Employee> itr=employees.iterator();
        while(itr.hasNext()){
            Employee e=itr.next();
            System.out.println(e);
        }
        session.close();
    }
}