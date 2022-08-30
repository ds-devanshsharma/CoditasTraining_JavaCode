package JDBC.Day3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResultSetDemo {
    static Connection connection;
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connection
            connection =DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC_DATABASE","root","Coditas@123");
            // updating Teacher record
            new UpdateRecord().updateRecord(connection);
//            new  UpdateRecord().deleteRecord(connection);
//            new UpdateRecord().insertRecord(connection);

        }catch (ClassNotFoundException | SQLException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}
/*
Initially
102 ANIRUDH MANAGER
110 Mahesh TRAINER
----------------------------------------
After updating row =1 with 101 "AARTI " while fetching Record
on console
-------------
110 Mahesh TRAINER
in DB
-------------
+-----+--------+-------------+
| TID | NAME   | DESIGNATION |
+-----+--------+-------------+
| 101 | AARTI  | MANAGER     |
| 110 | Mahesh | TRAINER     |
+-----+--------+-------------+
---------------------------------------------
if you want to update data while concurrent operation
then => PRIMARY KEY + Concurrency : updatable TYPE
                                    not this ResultSet.CONCUR_READ_ONLY
                                    this will allow you to read only from db
ERROR :Result Set not updatable.

 */