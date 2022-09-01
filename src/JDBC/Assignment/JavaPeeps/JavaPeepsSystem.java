package JDBC.Assignment.JavaPeeps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class JavaPeepsSystem {

    public static void main(String[] args) {
        try{
            System.out.println("WELCOME TO JAVA_PEEPS SYSTEM !! ");
                while(true) {
                    JavaPeepsMenu.operationMenu(ConnectionJDBC.getConnectionJDBC());
                }
        }catch (IOException | SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
