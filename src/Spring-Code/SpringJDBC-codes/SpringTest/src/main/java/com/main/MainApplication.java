package com.main;

import com.DAO.DAOImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static  DAOImplementation daoImplementation;
    //public static DAOImplementation daoImplementation ;
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
         daoImplementation =  context.getBean("Implementation",DAOImplementation.class);

        while(true){
            menu();
        }
    }
    public static void menu() throws IOException {
        System.out.println("Enter 1 for insert !\n" +
                            "Enter 2 for fetch !\n" +
                            "Enter 3 for Update !\n" +
                            "Enter 4 for Delete !\n" +
                            "Enter 5 fetch based on salary & city !\n" +
                            "Enter 6 for SortBy Lastname !\n" +
                            "Enter 0 for Exit !\n");
        switch (Integer.parseInt(reader.readLine())){
            case 1 :
                daoImplementation.insertData();
                break;
            case 2:
                daoImplementation.fetchData();
                break;
            case 3:
                daoImplementation.updateData();
                break;
            case 4:
                daoImplementation.deleteData();
                break;
            case 5:
                daoImplementation.fetchBasedOnCondition();
                break;
            case 6 :
                daoImplementation.sortBasedOnCondition();
                break;
            case 0:
                System.out.println("Logged Out");
                System.exit(0);

        }
    }
}
