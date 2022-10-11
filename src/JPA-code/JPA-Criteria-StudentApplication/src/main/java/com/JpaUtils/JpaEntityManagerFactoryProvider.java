package com.JpaUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManagerFactoryProvider {
    private static EntityManagerFactory entityManagerFactory ;

    private JpaEntityManagerFactoryProvider(){}
    public static EntityManagerFactory entityManagerFactoryProvider(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        }
        return entityManagerFactory;
    }
}
