package com.main;

import com.DAO.CRUDOperationImplemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    CRUDOperationImplemention implemention = new CRUDOperationImplemention();
    public void menu() throws IOException {
        while(true) {
            System.out.println("ENTER 1 FOR INSERT BOOK !\n" +
                    "ENTER 2 FOR FETCH ALL BOOK !\n" +
                    "ENTER 3 FOR DELETE BOOK !\n" +
                    "ENTER 4 FOR UPDATE BOOK !\n" +
                    "ENTER 0 FOR EXIT ! ");
            switch(Integer.parseInt(reader.readLine())){
                case 1 :
                    implemention.insertData();
                    break;
                case 2 :
                    implemention.fetchData();
                    break;
                case 3 :
                    implemention.deleteData();
                    break;
                case 4:
                    implemention.updateData();
                    break;
                case 0 :
                    System.out.println("LOGGED OUT SUCCESSFULLY !!!");System.exit(1);
            }
        }
    }
}
