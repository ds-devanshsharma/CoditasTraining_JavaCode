package com.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    private SessionFactoryProvider(){}
    public static SessionFactory sessionFactory ;
    public static SessionFactory sessionFactoryProvider(){
        if(sessionFactory==null){
            Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
