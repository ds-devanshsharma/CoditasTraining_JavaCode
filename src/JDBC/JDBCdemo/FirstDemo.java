package JDBC.JDBCdemo;

import javax.sql.StatementEvent;
import java.sql.*;

import static java.lang.Class.forName;

public class FirstDemo {
    public static void main(String[] args) {
       try {
           // DriverManager
           Class.forName("com.mysql.jdbc.Driver");
           // Connection
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_database","root","Coditas@123");
           // statement
            Statement statement = connection.createStatement();
            //prepareQuery

           // resultSet
           ResultSet resultSet = statement.executeQuery("SELECT * FROM JAVA_PEEPS");
           System.out.println("Using normal Statement : ");
           while(resultSet.next()){
               System.out.println(resultSet.getInt(1) +" " + resultSet.getString(2)+" "+resultSet.getString(3));
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
}
/*
Using normal Statement :
11056 DEVANSH SHARMA  KANPUR
11067 ANUJ DEHRADOON

 */