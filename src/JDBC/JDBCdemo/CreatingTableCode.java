package JDBC.JDBCdemo;

import javax.management.Query;
import java.sql.*;

class CreateTable{
    String url = "jdbc:mysql://localhost:3306/jdbc_database";
    String user= "root";
    String password= "Coditas@123";
    Connection connection ;
    PreparedStatement preparedStatement ;
    int check ;
    void CreateTable(){

        try
        {   // Driver
            Class.forName("com.mysql.jdbc.Driver");
            //connection
           connection =  DriverManager.getConnection(url,user,password);
           // statement
            String query="CREATE TABLE FRIENDS2 (ID INT ,NAME VARCHAR(10),CITY VARCHAR(10),COMPANY VARCHAR(20)) ";
            preparedStatement = connection.prepareStatement(query);
            // executingQuery
            /*
            this executeUpdate() return >0 ---> DML
                                 return == 0 -> DDL
             */
            check = preparedStatement.executeUpdate();

            if(check == 0) System.out.println("TABLE CREATED SUCCESSFULLY !!!");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
public class CreatingTableCode {
    public static void main(String[] args) {
        new CreateTable().CreateTable();
    }
}
/*
friends2 TABLE CREATION
------------------------
TABLE CREATED SUCCESSFULLY !!!
===============================================================================
friends2 TABLE DELETION
------------------------
 */