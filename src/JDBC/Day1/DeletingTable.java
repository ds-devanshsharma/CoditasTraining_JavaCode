package JDBC.Day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DeleteTableCode{
    String url = "jdbc:mysql://localhost:3306/jdbc_database";
    String user= "root";
    String password= "Coditas@123";
    Connection connection ;
    PreparedStatement preparedStatement ;
    int check ;
    void deleteTable(){

        try
        {   // Driver
            Class.forName("com.mysql.jdbc.Driver");
            //connection
            connection =  DriverManager.getConnection(url,user,password);
            // statement
            String query="DROP TABLE FRIENDS2 ";
            preparedStatement = connection.prepareStatement(query);
            // executingQuery
            /*
            this executeUpdate() return >0 ---> DML
                                 return == 0 -> DDL
             */
            check = preparedStatement.executeUpdate();

            if(check == 0) System.out.println("TABLE DELETED SUCCESSFULLY !!!");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class DeletingTable {
    public static void main(String[] args) {
        new DeleteTableCode().deleteTable();
    }
}
/*
FRIENDS2 DELETION
---------------------
TABLE DELETED SUCCESSFULLY !!!
 */