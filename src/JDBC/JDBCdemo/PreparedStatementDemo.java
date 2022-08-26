package JDBC.JDBCdemo;

import java.sql.*;

class PreparedStatementcode{
    Connection connection ;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    void CRUD(){
        try {
            // Driver

            Class.forName("com.mysql.jdbc.Driver");
            //Connection
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_database ",
                    "root","Coditas@123");
            //statement
            preparedStatement = connection.prepareStatement("SELECT * FROM JAVA_PEEPS");
            //executing Query
            resultSet =preparedStatement.executeQuery();
            if(resultSet!=null) System.out.println("RECORD FETCHED FROM DATABASE !");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) +" " + resultSet.getString(2)+" "+resultSet.getString(3));
            }
        }catch(ClassNotFoundException | SQLException e ){
            System.out.println(e.getMessage());
        }
    }
}
public class PreparedStatementDemo {
    public static void main(String[] args) {
        new PreparedStatementcode()
                .CRUD();
    }
}
/*
using preparedStatement
------------------------------------------------------------------------------------------------
RECORD FETCHED FROM DATABASE !
11067 ANUJ UK
11057 ADITYA  PUNE
 */