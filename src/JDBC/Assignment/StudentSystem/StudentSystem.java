package JDBC.Assignment.StudentSystem;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;

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
//            new Cases().fetchCase3(connection);
            //case 4.1 add Three records
//            new Cases().case4(connection);
            //case 4.2 update name=> Mr + name
//            new Cases().case4Update(connection);
            //case4.3=>remove those student who are in last year
            new Cases().case4Remove(connection);
        }catch(SQLException | ClassNotFoundException | InputMismatchException e){
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
case 2
13 ASHI     FY 80.0     GZB F
19 DEVANSH  FY 75.14    CNB M
56 NEGI     FY 74.8     CNB M
28 HIMANSHU FY 83.0     JHA M
57 SIMRAN   FY 72.0     VAR F
---------------------------------------
case 3
FETCH DATA IN RANGE 20-50
---------------------------------------
        26     SATYAM         TY  71.000000        CNB          M
        28   HIMANSHU         FY  83.000000        JHA          M
        30     MANISH         FY  69.000000        GOR          M
---------------------------------------------------------------------
case 4
mysql> select * from student_copy;
+----+----------+------+------------+------+--------+
| ID | NAME     | YEAR | PERCENTAGE | CITY | GENDER |
+----+----------+------+------------+------+--------+
| 12 | Ashutosh | FY   |         55 | CNB  | M      |
| 13 | ASHI     | FY   |         80 | GZB  | F      |
| 19 | DEVANSH  | FY   |      75.14 | CNB  | M      |
| 26 | SATYAM   | TY   |         71 | CNB  | M      |
| 28 | HIMANSHU | FY   |         83 | JHA  | M      |
| 30 | MANISH   | FY   |         69 | GOR  | M      |
| 56 | NEGI     | FY   |       74.8 | CNB  | M      |
| 57 | SIMRAN   | FY   |         72 | VAR  | F      |
| 61 | PRIYANKA | FY   |         70 | JHA  | F      |
+----+----------+------+------------+------+--------+
9 rows in set (0.00 sec)
CASE 4.3
BEFORE
----------
+----+----------+------+------------+------+--------+
| ID | NAME     | YEAR | PERCENTAGE | CITY | GENDER |
+----+----------+------+------------+------+--------+
| 12 | Ashutosh | FY   |         55 | CNB  | M      |
| 13 | ASHI     | FY   |         80 | GZB  | F      |
| 19 | DEVANSH  | FY   |      75.14 | CNB  | M      |
| 26 | SATYAM   | TY   |         71 | CNB  | M      |
| 28 | HIMANSHU | FY   |         83 | JHA  | M      |
| 30 | MANISH   | FY   |         69 | GOR  | M      |
| 56 | NEGI     | FY   |       74.8 | CNB  | M      |
| 57 | SIMRAN   | FY   |         72 | VAR  | F      |
| 61 | PRIYANKA | FY   |         70 | JHA  | F      |
+----+----------+------+------------+------+--------+
9 rows in set (0.00 sec)
AFTER REMOVING YEAR = 'FY'
-----------------------------------------------------
 26     SATYAM         TY  71.000000        CNB     M
 */