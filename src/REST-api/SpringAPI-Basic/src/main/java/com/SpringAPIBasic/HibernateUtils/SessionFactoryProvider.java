package com.SpringAPIBasic.HibernateUtils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    private static SessionFactory sessionFactory ;
    private SessionFactoryProvider(){
    }

    public static SessionFactory sessionFactoryProviderMethod(){
        if(sessionFactory==null){
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;

    }
}
