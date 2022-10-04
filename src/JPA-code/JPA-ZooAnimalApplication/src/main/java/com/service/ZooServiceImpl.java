package com.service;

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
    EntityManagerFactory entityManagerFactory = Persistence.
            createEntityManagerFactory("ZooUnit");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Zoo zoo;
    Animal animal;
    @Override
    public void addZoo(Zoo zoo) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(zoo);
        entityManager.getTransaction().commit();
    }

    @Override
    public void addAnimalToZoo(int zooID) throws IOException {
        boolean flag = true;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        zoo = entityManager.find(Zoo.class,zooID);
        System.out.println(zoo);
        List<Animal> list=zoo.getAnimal();
        while(flag){
            animal = new Animal();
            System.out.println("Enter Animal name : ");
            animal.setAnimalName(reader.readLine());
            System.out.println("ENter Animal Category :");
            animal.setCategory(reader.readLine());
            animal.setZoo(zoo);
            list.add(animal);

            System.out.println("WANT TO ADD MORE ANIMAL ??\n" +
                    "1-YES\n" +
                    "0-NO");
            if(Integer.parseInt(reader.readLine())==0) flag=false;

        }
        //entityManager.persist(list);
        zoo.setAnimal(list);

        entityManager.persist(zoo);
        entityManager.getTransaction().commit();
        System.out.println("ANIMAL ADDED SUCCESSFULLY !!");
    }

    @Override
    public void displayZoo(int zooID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.find(Zoo.class,zooID));
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
        System.out.println("For Now you can update Only Name OF the Zoo :D \n" +
                "Enter Name to update ZooName : ");
        zoo.setZooName(reader.readLine());
        entityManager.persist(zoo);
        entityManager.getTransaction().commit();
        System.out.println("Zoo Updated Successfully !! ");
    }
}
