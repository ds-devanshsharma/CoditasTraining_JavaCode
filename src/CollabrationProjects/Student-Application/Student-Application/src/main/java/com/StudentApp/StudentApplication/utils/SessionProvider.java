package com.StudentApp.StudentApplication.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
    private static SessionFactory sessionFactory ;
    private SessionProvider(){
    }

    public static SessionFactory sessionFactoryProvider(){
        if(sessionFactory==null){
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;

    }
}
