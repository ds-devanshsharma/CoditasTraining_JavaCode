package JDBC.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static JDBC.Assignment.FetchBasedOnCondition.connection;

public class DeleteBasedOnCondition{
    PreparedStatement preparedStatement;
    public static void main(String[] args) {
        try {
            // Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC_DATABASE","root","Coditas@123");
            new DeleteBasedOnCondition().deleteData(connection);
            //using another class showDATA() to just print RESULT on database;
            new EmployeeSystem().showData(connection);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private void deleteData(Connection connection) throws SQLException {
        preparedStatement =connection.prepareStatement("DELETE FROM EMPLOYEE WHERE STATUS =? ");
        preparedStatement.setInt(1,0);
        int check =preparedStatement.executeUpdate();
        if(check!=0)System.out.println("DATA DELETED SUCCESSFULLY !!");
        else System.out.println("SOMETHING WENT WRONG !");
    }
}
/*
DATA DELETED SUCCESSFULLY !!
11056 DEVANSH ASE 2022-07-11 0 45000 1
___________________________________________________________________________
11057 ANUJ ASE 2022-08-11 1 45000 1
___________________________________________________________________________
11058 ZULFA SE 2022-11-22 3 48000 1
___________________________________________________________________________
 */