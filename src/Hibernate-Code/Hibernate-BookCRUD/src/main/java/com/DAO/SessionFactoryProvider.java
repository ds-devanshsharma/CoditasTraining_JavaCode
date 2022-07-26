package com.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    public static SessionFactory sessionFactory;
    private SessionFactoryProvider(){}
    public static SessionFactory getSessionFactoryProvider(){
        if(sessionFactory==null){
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
