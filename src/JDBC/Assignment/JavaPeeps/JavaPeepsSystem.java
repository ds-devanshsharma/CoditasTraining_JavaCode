package JDBC.Assignment.JavaPeeps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaPeepsSystem {
    static Connection connection ;
    public static void main(String[] args) {

        BufferedReader reader = null;
        try{
        String url ="jdbc:mysql://localhost:3306/JDBC_DATABASE";
        String user = "root";
        reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("ENTER DB PASSWORD :: ");
        String password = reader.readLine();
        if(!password.equals("Coditas@123")){
            System.out.println("WRONG DB PASSWORD !!");
            System.exit(0);
        }
            // Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection
            connection =DriverManager.getConnection(url,user,password);


            System.out.println("WELCOME TO JAVA_PEEPS SYSTEM !! ");
                while(true) {
                    JavaPeepsMenu.operationMenu(connection);
                }
        }catch (ClassNotFoundException | SQLException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}
