package com.main;
import com.DAOHotel.HotelOperation;
import com.DAOHotel.HotelOperationImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
    HotelOperation implementation = new HotelOperationImpl();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    void menu() {
        try{
        while(true){
            System.out.println("ENTER 1 FOR ADD HOTEL \n" +
                    "ENTER 2 TO FETCH ALL HOTEL \n" +
                    "ENTER 3 TO FETCH HOTEL BY ID \n" +
                    "ENTER 4 TO DELETE HOTEL \n" +
                    "ENTER 5 TO UPDATE HOTEL \n" +
                    "ENTER 0 TO EXIT !! \n");
            switch(Integer.parseInt(reader.readLine())){
                case 1 :
                    implementation.addDish();
                    break;
                case 2 :
                    implementation.displayDish();
                    break;
                case 4 :
                   implementation.deleteDish();
                    break;
                case 5 :
                    implementation.updateDish();
                    break;
                case  0:
                    System.out.println("LOGGED OUT SUCCESSFULLY !! ");
                    System.exit(1);
            }
        }
        }catch (Exception e ){
            e.printStackTrace();
            menu();
        }
    }
}
