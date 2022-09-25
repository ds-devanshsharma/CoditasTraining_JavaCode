package com.main;

import com.DAO.StudentOperation.StudentOperationImplementation;
import com.DAO.StudentOperation.StudentOperationList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    StudentOperationList operationList  = new StudentOperationImplementation();
    void menu() throws IOException {
        do{
            System.out.println("Enter 1 for insert !\n" +
                    "Enter 2 for fetch !\n" +
                    "Enter 3 for Update !\n" +
                    "Enter 4 for Delete !\n" +
                    "Enter 0 for Exit !\n");
            switch (Integer.parseInt(reader.readLine())){
                case 1 :
                    operationList.insertStudent();
                    break;
                case 2 :
                    operationList.updateStudent();
                    break;
                case 3 :
                    operationList.deleteStudent();
                    break;
                case 4 :
                    operationList.fetchStudent();
                    break;
                case 0 :
                    System.out.println("LOGGED OUT SUCCESSFULLY !!");System.exit(1);
            }
        }while(true);
    }
}
