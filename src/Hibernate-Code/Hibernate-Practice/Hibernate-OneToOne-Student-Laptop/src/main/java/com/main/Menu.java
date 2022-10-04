package com.main;

import com.DAOAssest.AssetOperation;
import com.DAOAssest.AssetOperationImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    AssetOperation operation = new AssetOperationImpl();
    void menu() {
        try{
            while(true){
                System.out.println("ENTER 1 FOR REGISTER ASSET : \n" +
                        "ENTER 2 FOR FETCH : \n" +
                        "ENTER 3 FOR DELETE ASSEt RECORD : \n" +
                        "ENTER 4 FOR UPDATE : \n");
                switch (Integer.parseInt(reader.readLine())){
                    case 1 :
                        operation.registerAsset();
                        break;
                    case 2 :
                        operation.displayAsset();
                        break;
                }
            }
        }catch(Exception e ){
            System.out.println(e.getMessage());
            menu();
        }
    }
}
