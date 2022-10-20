package com.service;

import com.JPAutil.EntityManagerFactoryProvider;
import com.bean.Animal;
import com.bean.Zoo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ZooServiceImpl implements ZooService{
    EntityManagerFactory entityManagerFactory = EntityManagerFactoryProvider.EntityMangerFactoryProviderMethod();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Zoo zoo;
    @Override
    public void addZoo(Zoo zoo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(zoo);
        entityManager.getTransaction().commit();
    }

    @Override
    public void displayZoo(int zooID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        zoo = entityManager.find(Zoo.class,zooID);
        System.out.println(zoo);
    }
    public void displayZooList(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       List<Zoo> list =  entityManager.createQuery("from Zoo").getResultList();
       list.stream().forEach(System.out::println);
    }

    @Override
    public void deleteZoo(int zooID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        zoo = entityManager.find(Zoo.class,zooID);
        entityManager.remove(zoo);
        entityManager.getTransaction().commit();
        System.out.println("Zoo Deleted Successfully !!");
    }

    @Override
    public void updateZoo(int zooID) throws IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        zoo = entityManager.find(Zoo.class,zooID);
        System.out.println("ENTER new ZOO NAME : \n");
        zoo.setZooName(reader.readLine());
        entityManager.persist(zoo);
        entityManager.getTransaction().commit();
        System.out.println("Zoo Updated Successfully !! ");
    }
}
