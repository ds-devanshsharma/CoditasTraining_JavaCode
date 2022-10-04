package com.main;

import com.bean.Animal;
import com.bean.Zoo;
import com.service.ZooService;
import com.service.ZooServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ZooService zooService = new ZooServiceImpl();
    Zoo zoo;
    Animal animal ;

    void menu() throws IOException {
        try {
            while (true) {
                System.out.println("ENTER 1 TO ADD ZOO \n" +
                        "ENTER 2 TO ADD ANIMAL TO ZOO \n" +
                        "ENTER 3 TO DISPLAY ZOO \n" +
                        "ENTER $ TO DISPLAY ZooLIST \n" +
                        "ENTER 5 TO DELETE ZOO \n" +
                        "ENTER 6 TO UPDATE ZOO \n" +
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
                        System.out.println("ENTER zooID TO ADD ANIMAL : ");
                        int zooID = Integer.parseInt(reader.readLine());
                        zooService.addAnimalToZoo(zooID);
                        break;
                    case 3:
                        System.out.println("ENTER ZOO-ID TO DISPLAY base on ZooID: \n");
                        zooService.displayZoo(Integer.parseInt(reader.readLine()));
                        break;

                    case 4 :
                        zooService.displayZooList();
                        break;
                    case 5:
                        System.out.println("ENTER ZOO-ID TO DELETE Zoo : \n");
                        zooService.deleteZoo(Integer.parseInt(reader.readLine()));
                        break;
                    case 6:
                        System.out.println("ENTER Zoo-ID TO UPADTE Zoo : \n");
                        zooService.updateZoo(Integer.parseInt(reader.readLine()));
                        break;
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
