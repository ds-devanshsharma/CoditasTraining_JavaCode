package JDBC.Assignment.DAOBasedAppication.JavaPeepsSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JavaPeepsSystem {

    public static void main(String[] args) {
        try{
        Connection connection = ConnectionJDBC.getConnectionJDBC();

            System.out.println("WELCOME TO JAVA_PEEPS SYSTEM !! ");
                while(true) {
                    JavaPeepsMenu.operationMenu(connection);
                }
        }catch (IOException | SQLException |ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
