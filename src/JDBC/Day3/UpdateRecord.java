package JDBC.Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class UpdateRecord {
    Statement statement ;
    ResultSet resultSet ;
    BufferedReader reader ;
    static void printer(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+" "
                    +resultSet.getString(2)+" "+resultSet.getString(3));
        }
    }
    void updateRecord(Connection connection ) throws SQLException, IOException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String query = "SELECT * FROM TEACHER ";
        resultSet =statement.executeQuery(query);
        resultSet.absolute(4);
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Name : ");
        resultSet.updateString(2, reader.readLine());
        resultSet.updateRow();
        resultSet.absolute(0);
        printer(resultSet);

    }
    void insertRecord(Connection connection) throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String query = "SELECT * FROM TEACHER ";
        resultSet =statement.executeQuery(query);
        resultSet.absolute(1);
        resultSet.updateInt(1,222);
        resultSet.updateString(2,"SANYUKTA");
        resultSet.updateString(3,"MANAGER");
        resultSet.insertRow();

        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+" "
                    +resultSet.getString(2)+" "+resultSet.getString(3));
        }
    }
    void deleteRecord(Connection connection) throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String query = "SELECT * FROM TEACHER ";
        resultSet =statement.executeQuery(query);
        resultSet.absolute(2);
        resultSet.deleteRow();
        resultSet.absolute(1);
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+" "
                    +resultSet.getString(2)+" "+resultSet.getString(3));
        }
    }
}
/*
We are trying to delete a specific row while fetching data:
----------------------------------------------------------
before:
101 AARTI MANAGER
102 ANIRUDH MANAGER
after :
on DB
+-----+-------+-------------+
| TID | NAME  | DESIGNATION |
+-----+-------+-------------+
| 101 | AARTI | MANAGER     |
+-----+-------+-------------+
-------------------------------------------
try to update data of row 4 with
Enter Name :
Piyush
on console
-------------------
101 AARTI Trainer
111 ANIRUDH MANAGER
112 VARUN DIRECTOR
119 Piyush Trainer
199 Yuvraj TEAMLEAD
+-----+---------+-------------+
| TID | NAME    | DESIGNATION |
+-----+---------+-------------+
| 101 | AARTI   | Trainer     |
| 109 | ANWAY   | SE          |
| 111 | ANIRUDH | MANAGER     |
| 112 | VARUN   | DIRECTOR    |
| 119 | Piyush  | Trainer     |
| 199 | Yuvraj  | TEAMLEAD    |
+-----+---------+-------------+
 */