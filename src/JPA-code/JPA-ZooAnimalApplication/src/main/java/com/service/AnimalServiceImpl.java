package com.service;

import com.JPAutil.EntityManagerFactoryProvider;
import com.bean.Animal;
import com.bean.Zoo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AnimalServiceImpl implements AnimalService{
    Animal animal ;
    Zoo zoo;
    EntityManagerFactory entityManagerFactory = EntityManagerFactoryProvider.EntityMangerFactoryProviderMethod();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void addAnimalToZoo(Zoo zoo) throws IOException {
            boolean flag = true;
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Animal> list=zoo.getAnimal();
            while(flag){
                animal = new Animal();
                System.out.println("Enter Animal name : ");
                animal.setAnimalName(reader.readLine());
                System.out.println("Enter Animal Category :");
                animal.setCategory(reader.readLine());
                System.out.println("Enter Animal Age : ");
                animal.setAnimalAge(Integer.parseInt(reader.readLine()));
                animal.setZoo(zoo);
                list.add(animal);
                System.out.println("WANT TO ADD MORE ANIMAL ??\n" +
                        "1-YES\n" +
                        "0-NO");
                if(Integer.parseInt(reader.readLine())==0) flag=false;
            }
            try {
                zoo.setAnimal(list);
                entityManager.persist(zoo);
                entityManager.getTransaction().commit();
                System.out.println("ANIMAL ADDED SUCCESSFULLY !!");
            }catch (Exception e ){
                e.printStackTrace();
            }
    }


    @Override
    public void showAnimalInZoo(Zoo zoo) {
        System.out.println("ANIMAL IN ->"+ zoo.getZooName() );
        zoo.getAnimal().stream().forEach(System.out::println);
    }

    @Override
    public void deleteAnimalFromZoo(Zoo zoo) throws IOException {
        System.out.println("ANIMAL IN THIS Zoo : ");showAnimalInZoo(zoo);
        System.out.println("ENTER ANIMAL-ID TO DELETE ANIMAL : ");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Animal.class,Integer.parseInt(reader.readLine())));
        zoo.setAnimal(zoo.getAnimal());
        entityManager.getTransaction().commit();
        System.out.println("ANIMAL DELETED SUCCESSFULLY !! ");

    }

    @Override
    public void updateAnimalInZoo(Zoo zoo) {

    }
}
