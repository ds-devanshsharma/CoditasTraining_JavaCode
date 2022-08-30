package JDBC.Assignment.ImageOperation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ImageOperation {
    static Connection connection;
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC_DATABASE","root","Coditas@123");
            new InsertImg().addingImage(connection);
        }catch(ClassNotFoundException | SQLException  | IOException e){
            System.out.println(e.getMessage());
        }
    }
}
