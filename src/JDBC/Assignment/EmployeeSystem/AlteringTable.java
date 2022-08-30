package JDBC.Assignment.EmployeeSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlteringTable {
    static Connection connection =null;
    PreparedStatement preparedStatement =null;
    void addCityColumn(Connection connection ) throws SQLException {
        //preparedStatement
        preparedStatement =connection.prepareStatement("ALTER TABLE EMPLOYEE ADD COLUMN CITY VARCHAR(20) ");
        //executing
        int check =preparedStatement.executeUpdate(); // 0 because Zero row affected
        if(check!=0)System.out.println("COLUMN ADDED SUCCESSFULLY !!");
        else System.out.println("SOMETHING WENT WRONG !!");
    }

    public static void main(String[] args) {
        try {// Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DATABASE",
                    "root","Coditas@123");
            //preparedStatement
            //calling alterMethod
            new AlteringTable().addCityColumn(connection);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
/*
mysql> SELECT * FROM EMPLOYEE ;
+-------+---------+-------------+------------+------------+--------+--------+------+
| ID    | NAME    | DESIGNATION | DOJ        | EXPERIENCE | SALARY | STATUS | CITY |
+-------+---------+-------------+------------+------------+--------+--------+------+
| 11056 | DEVANSH | ASE         | 2022-07-11 |          0 |  45000 |      1 | NULL |
| 11057 | ANUJ    | ASE         | 2022-08-11 |          1 |  45000 |      1 | NULL |
| 11058 | ZULFA   | SE          | 2022-11-22 |          3 |  47000 |      1 | NULL |
| 10056 | PRATEEK | SE          | 2020-01-10 |          3 |  56000 |      0 | NULL |
+-------+---------+-------------+------------+------------+--------+--------+------+
4 rows in set (0.00 sec)
 */
