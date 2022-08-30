package JDBC.Assignment.EmployeeSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static JDBC.Assignment.EmployeeSystem.FetchBasedOnCondition.connection;

public class UpdateBasedOnCondition {
    PreparedStatement preparedStatement;
    void updateData(Connection connection) throws SQLException {
        preparedStatement =connection.prepareStatement(
                "Update EMPLOYEE set salary = (salary+1000) where experience >1");
       int check =  preparedStatement.executeUpdate();
       if(check!=0) System.out.println("DATA UPDATED SUCCESSFULLY  !!");
    }

    public static void main(String[] args) {
        try {
            // Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC_DATABASE","root","Coditas@123");
            new UpdateBasedOnCondition().updateData(connection);
        }catch (ClassNotFoundException | SQLException  e){
            System.out.println(e.getMessage());
        }
    }
}
/*
mysql> SELECT * FROM EMPLOYEE;
+-------+---------+-------------+------------+------------+--------+--------+--------+
| ID    | NAME    | DESIGNATION | DOJ        | EXPERIENCE | SALARY | STATUS | CITY   |
+-------+---------+-------------+------------+------------+--------+--------+--------+
| 11056 | DEVANSH | ASE         | 2022-07-11 |          0 |  45000 |      1 | KANPUR |
| 11057 | ANUJ    | ASE         | 2022-08-11 |          1 |  45000 |      1 | UK     |
| 11058 | ZULFA   | SE          | 2022-11-22 |          3 |  47000 |      1 | PUNE   |
| 10056 | PRATEEK | SE          | 2020-01-10 |          3 |  56000 |      0 | UK     |
+-------+---------+-------------+------------+------------+--------+--------+--------+
4 rows in set (0.00 sec)

DATA UPDATED SUCCESSFULLY  !!
mysql> SELECT * FROM EMPLOYEE;
+-------+---------+-------------+------------+------------+--------+--------+--------+
| ID    | NAME    | DESIGNATION | DOJ        | EXPERIENCE | SALARY | STATUS | CITY   |
+-------+---------+-------------+------------+------------+--------+--------+--------+
| 11056 | DEVANSH | ASE         | 2022-07-11 |          0 |  45000 |      1 | KANPUR |
| 11057 | ANUJ    | ASE         | 2022-08-11 |          1 |  45000 |      1 | UK     |
| 11058 | ZULFA   | SE          | 2022-11-22 |          3 |  48000 |      1 | PUNE   |
| 10056 | PRATEEK | SE          | 2020-01-10 |          3 |  57000 |      0 | UK     |
+-------+---------+-------------+------------+------------+--------+--------+-------
 */


