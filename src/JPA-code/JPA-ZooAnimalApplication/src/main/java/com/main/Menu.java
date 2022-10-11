package com.main;

import com.JPAutil.EntityManagerFactoryProvider;
import com.bean.Animal;
import com.bean.Zoo;
import com.service.AnimalService;
import com.service.AnimalServiceImpl;
import com.service.ZooService;
import com.service.ZooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ZooService zooService = new ZooServiceImpl();
    AnimalService animalService = new AnimalServiceImpl();
    Zoo zoo;
    Animal animal ;
    EntityManagerFactory entityManagerFactory = EntityManagerFactoryProvider.EntityMangerFactoryProviderMethod();

    void menu() throws IOException {
        try {
            while (true) {
                System.out.println("ENTER 1 TO ADD ZOO \n" +
                        "ENTER 2 TO DISPLAY ZOO \n" +
                        "ENTER 3 TO DISPLAY ZooLIST \n" +
                        "ENTER 4 TO DELETE ZOO \n" +
                        "ENTER 5 TO UPDATE ZOO \n" +
                        "ENTER 6 TO MANAGE ZOO \n" +
                        "ENTER 7 TO GET ANIMAL GREATER THAN 10 \n" +
                        "ENTER 0 TO EXIT \n" +
                        "");
                switch (Integer.parseInt(reader.readLine())) {
                    case 1:
                        zoo = new Zoo();
                        System.out.println("ENTER ZOO NAME : ");
                        zoo.setZooName(reader.readLine());
                        zooService.addZoo(zoo);
                        break;

                    case 2:
                        System.out.println("ENTER ZOO-ID TO DISPLAY base on ZooID: \n");
                        zooService.displayZoo(Integer.parseInt(reader.readLine()));
                        break;

                    case 3 :
                        zooService.displayZooList();
                        break;
                    case 4:
                        System.out.println("ENTER ZOO-ID TO DELETE Zoo : \n");
                        zooService.deleteZoo(Integer.parseInt(reader.readLine()));
                        break;
                    case 5:
                        System.out.println("ENTER Zoo-ID TO UPADTE Zoo : \n");
                        zooService.updateZoo(Integer.parseInt(reader.readLine()));
                        break;
                    case 6 :
                        System.out.println("ENTER ZooID YOU WANT TO MANAGE : ");
                        EntityManager entityManager =
                                entityManagerFactory.createEntityManager();
                        entityManager.getTransaction().begin();
                        zoo = entityManager.find(Zoo.class,Integer.parseInt(reader.readLine()));
                        System.out.println(" *****************WELCOME TO ANIMAL MANAGEMENT SECTION **************");
                        System.out.println("ENTER 1 TO ADD ANIMAL TO Zoo:\n" +
                                "ENTER 2 TO DELETE ANIMAL FROM Zoo :\n" +
                                "ENETR 3 TO UPDATE ANIMAL IN Zoo :\n");
                        switch(Integer.parseInt(reader.readLine())){
                            case 1 :
                                animalService.addAnimalToZoo(zoo);
                                break;
                            case 2:
                                animalService.deleteAnimalFromZoo(zoo);
                                break;
                            case 3 :
                                animalService.updateAnimalInZoo(zoo);
                                break;
                        }
                        entityManager.getTransaction().commit();
                        break;
                    case 7 :
//                        animalService.
                    case 0 :
                        System.out.println("Logged Out From Zoooo !! ");
                        System.exit(1);
                }
            }
        }catch (Exception e ){
            e.getMessage();
            menu();
        }
    }
}
/*
                System.out.println(" *****************WELCOME TO ANIMAL MANAGEMENT SECTION **************");
                System.out.println("ENTER 1 TO ADD ANIMAL TO Zoo:\n" +
                        "ENTER 2 TO DELETE ANIMAL FROM Zoo :\n" +
                        "ENETR 3 TO UPDATE ANIMAL IN Zoo :\n");
                switch(Integer.parseInt(reader.readLine())){
                    case 1 :
                        animalService.addAnimalToZoo(zoo);
                        break;
                    case 2:
                        animalService.deleteAnimalFromZoo(zoo);
                        break;
                    case 3 :
                        animalService.updateAnimalInZoo(zoo);
                        break;
                }
 */