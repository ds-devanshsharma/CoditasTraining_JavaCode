package JDBC.Assignment.StudentSystem;

import java.io.File;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentSystem {
    static Connection connection ;
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC_DATABASE","root","Coditas@123");
            // case 1 ADD GENDER COLUMN
//            new Cases().addGenderColumn(connection);
            // case 2 FETCH "FY" AND PERCENTAGE > 70
//            new Cases().fetchCase1(connection);
            // case 3 id in range 20-50
            new Cases().fetchCase3(connection);
        }catch(SQLException |ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
/*
mysql> DESC STUDENT;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| ID         | int         | YES  |     | NULL    |       |
| NAME       | varchar(20) | YES  |     | NULL    |       |
| YEAR       | date        | YES  |     | NULL    |       |
| PERCENTAGE | float       | YES  |     | NULL    |       |
| CITY       | varchar(10) | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
5 rows in set (0.01 sec)

mysql> desc STUDENT;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| ID         | int         | YES  |     | NULL    |       |
| NAME       | varchar(20) | YES  |     | NULL    |       |
| YEAR       | date        | YES  |     | NULL    |       |
| PERCENTAGE | float       | YES  |     | NULL    |       |
| CITY       | varchar(10) | YES  |     | NULL    |       |
| GENDER     | varchar(1)  | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
 */
/*
13 ASHI     FY 80.0     GZB F
19 DEVANSH  FY 75.14    CNB M
56 NEGI     FY 74.8     CNB M
28 HIMANSHU FY 83.0     JHA M
57 SIMRAN   FY 72.0     VAR F
 */