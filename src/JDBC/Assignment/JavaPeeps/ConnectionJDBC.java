package JDBC.Assignment.JavaPeeps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static JDBC.Assignment.JavaPeeps.JavaPeepsDAO.*;

public class ConnectionJDBC implements JavaPeepsDAO{
    static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    BufferedReader reader = null;
      private ConnectionJDBC(){

      }
//    private ConnectionJDBC() throws ClassNotFoundException, IOException, SQLException {
//
//        // Driver
//        Class.forName(driver);
//        reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("ENTER DB PASSWORD :: ");
//        String password = reader.readLine();
//        if(!password.equals("Coditas@123")){
//            System.out.println("WRONG DB PASSWORD !!");
//            System.exit(0);
//        }
//        //Connection
//        connection =DriverManager.getConnection(url,user,password);
//
//    }
    static Connection getConnectionJDBC() throws SQLException, IOException, ClassNotFoundException {
             return connection;
    }
}
