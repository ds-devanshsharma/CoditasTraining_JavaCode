package com;

import com.hibernateUtil.SessionFactoryProvider;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryProvider.sessionFactoryProviderMethod();
    }
}
