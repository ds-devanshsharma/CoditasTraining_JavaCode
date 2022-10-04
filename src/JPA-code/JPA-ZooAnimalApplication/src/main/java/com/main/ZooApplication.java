package com.main;

import com.JPAutil.EntityManagerFactoryProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ZooApplication {
    public static void main(String[] args) {
//        EntityManagerFactory managerFactory = EntityManagerFactoryProvider
//                .EntityMangerFactoryProviderMethod();
        try{
            new Menu().menu();
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
}
