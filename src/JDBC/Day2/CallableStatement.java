package JDBC.Day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CallableStatement {
    public static void main(String[] args) {
        Connection connection  =null;
        CallableStatement statement = null ;
        //
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DATABASE");
//            //statement
//            statement = connection.prepareCall("call ");




        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
