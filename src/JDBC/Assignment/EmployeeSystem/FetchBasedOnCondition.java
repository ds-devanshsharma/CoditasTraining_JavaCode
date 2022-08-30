package JDBC.Assignment.EmployeeSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * case4 Fetch only those Employees who are from PUNE and salary>20000
 */
public class FetchBasedOnCondition {
   static Connection connection =null;
   PreparedStatement preparedStatement ;
   ResultSet resultSet ;
   static BufferedReader reader ;

    void fetchData(Connection connection) throws SQLException, IOException {
        preparedStatement =connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE CITY = ? AND SALARY > ? ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ENTER CITY FOR SEARCH  : ");
        preparedStatement.setString(1,reader.readLine());
        System.out.println("ENTER SALARY FOR BETTER SEARCH : ");
        preparedStatement.setInt(2,Integer.parseInt(reader.readLine()));
        resultSet =preparedStatement.executeQuery();
        //printing DATA on console
        while(resultSet.next()){
            System.out.print(resultSet.getInt(1)+" "+resultSet.getString(2)+" "
                    +resultSet.getString(3)+ " "+resultSet.getDate(4)+" "+
                    resultSet.getInt(5)+ " "+resultSet.getInt(6)+" "+
                    resultSet.getInt(7) + " "+resultSet.getString(8));
        }
    }
    public static void main(String[] args) {
        try {
            // Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connection
            connection =DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC_DATABASE","root","Coditas@123");
            new FetchBasedOnCondition().fetchData(connection);
        }catch (ClassNotFoundException | SQLException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}
/*
ENTER CITY FOR SEARCH  :
PUNE
ENTER SALARY FOR BETTER SEARCH :
45000
11058 ZULFA SE 2022-11-22 3 47000 1 PUNE
 */