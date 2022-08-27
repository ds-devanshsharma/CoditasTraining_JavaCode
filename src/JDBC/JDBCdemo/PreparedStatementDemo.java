package JDBC.JDBCdemo;

import java.sql.*;
import java.util.Scanner;

class PreparedStatementcode{
    Connection connection ;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Scanner scanner ;
    int check;
    void CRUD(){
        try {
            // Driver

            Class.forName("com.mysql.jdbc.Driver");
            //Connection
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_database ",
                    "root","Coditas@123");
            //statement
            //SELECT
            //preparedStatement = connection.prepareStatement("SELECT * FROM JAVA_PEEPS");
            //INSERT
           // preparedStatement = connection.prepareStatement("Insert into JAVA_PEEPS values (?,?,?)");
            //DELETE
            preparedStatement = connection.prepareStatement("DELETE FROM JAVA_PEEPS WHERE I_ID = 11080 ");
            // taking input from USER
//            int flag =1;
//            scanner = new Scanner(System.in);

//            while(flag == 1) {
//                System.out.println("Enter 1 for add !! ");
//                int choice =scanner.nextInt();
//                switch(choice) {
//                    case 1 :
//                            System.out.println("Enter ID : ");
//                            preparedStatement.setInt(1, scanner.nextInt());
//                            System.out.println("Enter Name : ");
//                            preparedStatement.setString(2, scanner.next());
//                            System.out.println("Enter City : ");
//                            preparedStatement.setString(3, scanner.next());
//                            break;
//                    default:
//                        flag =0;
//                        break;
//                }
//            }
//            //excuteUpdate
//            check=preparedStatement.executeUpdate();
//            if(check>0) System.out.println("Data Inserted  Succesfully !");
            check =preparedStatement.executeUpdate();
            if(check>0 ) System.out.println("DATA DELETED SUCCESSFULLY !!!");
            //executing Query
            preparedStatement = connection.prepareStatement("SELECT * FROM JAVA_PEEPS");
            resultSet =preparedStatement.executeQuery();
            if(resultSet!=null) System.out.println("RECORD FETCHED FROM DATABASE !");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) +" " + resultSet.getString(2)+" "+resultSet.getString(3));
            }
        }catch(ClassNotFoundException | SQLException e ){
            System.out.println(e.getMessage());
        }
    }
}
public class PreparedStatementDemo {
    public static void main(String[] args) {
        new PreparedStatementcode()
                .CRUD();
    }
}
/*
using preparedStatement
------------------------------------------------------------------------------------------------
RECORD FETCHED FROM DATABASE !
11067 ANUJ UK
11057 ADITYA  PUNE

INSERT :
RECORD FETCHED FROM DATABASE !
11067 ANUJ UK
11057 ADITYA  PUNE
11080 Banergi VimanNagar
 ---------------------------------------------------------
 record fetched
 --------------
 RECORD FETCHED FROM DATABASE !
11067 ANUJ UK
11057 ADITYA  PUNE
11080 Banergi VimanNagar
11070 Dubey Mumbai
---------------------------------------------
DATA DELETED SUCCESSFULLY !!!
RECORD FETCHED FROM DATABASE !
11067 ANUJ UK
11057 ADITYA  PUNE
11070 Dubey Mumbai
---------------------------------------------
 */