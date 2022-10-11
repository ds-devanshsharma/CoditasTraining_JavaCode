package com.JPAutil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {
    private static EntityManagerFactory managerFactory ;
    private EntityManagerFactoryProvider(){}
    public static EntityManagerFactory EntityMangerFactoryProviderMethod(){
        if(managerFactory==null){
            managerFactory = Persistence.createEntityManagerFactory("ZooUnit");
        }
        return managerFactory;
    }
}
