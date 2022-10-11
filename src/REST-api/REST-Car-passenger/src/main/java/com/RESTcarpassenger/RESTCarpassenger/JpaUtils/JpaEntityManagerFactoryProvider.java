package com.RESTcarpassenger.RESTCarpassenger.JpaUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManagerFactoryProvider {
    static EntityManagerFactory entityManagerFactory;
    private JpaEntityManagerFactoryProvider(){}
    public static EntityManagerFactory getEntityManagerFactoryObject(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("CarPassenger");
        }
        return entityManagerFactory;
    }
}
