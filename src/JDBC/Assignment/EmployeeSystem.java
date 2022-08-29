package JDBC.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class EmployeeSystem {
    public static PreparedStatement preparedStatement =null;
    ResultSet resultSet = null;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    void showData(Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE ");
        resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.print(resultSet.getInt(1)+" "+resultSet.getString(2)+" "
                            +resultSet.getString(3)+ " "+resultSet.getDate(4)+" "+
                            resultSet.getInt(5)+ " "+resultSet.getInt(6)+" "+
                            resultSet.getInt(7));
            System.out.println("\n___________________________________________________________________________");
        }

    }

    void addData(Connection connection) throws SQLException, IOException {
        preparedStatement = connection.prepareStatement("Insert into employee values(?,?,?,?,?,?,?) ");
        int  choice =1;
        while(choice !=0){
            System.out.println("Welcome to ADD DATA !");
            System.out.println("Enter your ID :");

            preparedStatement.setInt(1, Integer.parseInt(reader.readLine()));
            System.out.println("Enter your name : ");
            preparedStatement.setString(2, reader.readLine());
            System.out.println("Enter your Designation : ");
            preparedStatement.setString(3, reader.readLine());
            System.out.println("Enter date of joining :");
            preparedStatement.setDate(4, Date.valueOf(reader.readLine()));
            System.out.println("Enter your Experience : ");
            preparedStatement.setInt(5, Integer.parseInt(reader.readLine()));
            System.out.println("Enter your salary : ");
            preparedStatement.setInt(6, Integer.parseInt(reader.readLine()));
            System.out.println("Enter your Status :");
            preparedStatement.setBoolean(7, Boolean.parseBoolean(reader.readLine()));
            preparedStatement.addBatch();
            System.out.println("DO YOU WANT TO ADD MORE DATA ?? \n" +
                                "ENTER 1 FOR YES\n" +
                                "ENTER 2 FOR NO ");
            if(Integer.parseInt(reader.readLine()) != 1) choice=0;
        }
    }

}
/*
Enter 1 for Adding DATA !
Enter 2 for Showing DATA
Enter 0 for Exit from MENU
___________________________________________________________________________
1
Welcome to ADD DATA !
Enter your ID :
11057
Enter your name :
ANUJ
Enter your Designation :
ASE
Enter date of joining :
2022-08-11
Enter your Experience :
1
Enter your salary :
45000
Enter your Status :
TRUE
DO YOU WANT TO ADD MORE DATA ??
ENTER 1 FOR YES
ENTER 2 FOR NO
1
Welcome to ADD DATA !
Enter your ID :
11058
Enter your name :
ZULFA
Enter your Designation :
SE
Enter date of joining :
2022-11-22
Enter your Experience :
3
Enter your salary :
47000
Enter your Status :
TRUE
DO YOU WANT TO ADD MORE DATA ??
ENTER 1 FOR YES
ENTER 2 FOR NO
1
Welcome to ADD DATA !
Enter your ID :
10056
Enter your name :
PRATEEK
Enter your Designation :
SE
Enter date of joining :
2020-01-10
Enter your Experience :
3
Enter your salary :
56000
Enter your Status :
FALSE
DO YOU WANT TO ADD MORE DATA ??
ENTER 1 FOR YES
ENTER 2 FOR NO
2
DATA ADDED SUCCESSFULLY !!
___________________________________________________________________________
Enter 1 for Adding DATA !
Enter 2 for Showing DATA
Enter 0 for Exit from MENU
___________________________________________________________________________
2
11056 DEVANSH ASE 2022-07-11 0 45000 1
___________________________________________________________________________
11057 ANUJ ASE 2022-08-11 1 45000 1
___________________________________________________________________________
11058 ZULFA SE 2022-11-22 3 47000 1
___________________________________________________________________________
10056 PRATEEK SE 2020-01-10 3 56000 0
___________________________________________________________________________
___________________________________________________________________________
Enter 1 for Adding DATA !
Enter 2 for Showing DATA
Enter 0 for Exit from MENU
___________________________________________________________________________
 */