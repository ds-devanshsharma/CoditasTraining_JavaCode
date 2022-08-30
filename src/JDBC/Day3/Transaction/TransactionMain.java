package JDBC.Day3.Transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.CompactNumberFormat;
import java.util.Scanner;

public class TransactionMain {
    static Connection connection ;
    static Scanner scanner;
    ResultSet resultSet;
    static void  printer(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){

            System.out.format("%20d %20s %20s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
        }
    }
    public static void main(String[] args) {
       try{     Class.forName("com.mysql.jdbc.Driver");
               //connection
               connection = DriverManager.getConnection(
                       "jdbc:mysql://localhost:3306/JDBC_DATABASE", "root", "Coditas@123");

               connection.setAutoCommit(false);
               new RollbackDemo().rollback(connection);

               System.out.println("DO WANT TO ROLLBACK-1 OR COMMIT-0 ");
               scanner =new Scanner(System.in);
          int commitOrRollback =scanner.nextInt();
          if(commitOrRollback ==0){
              connection.commit();
              System.out.println("DATA ADDED SUCCESFULLY !");
          }else{
              connection.rollback();
              System.out.println("DATA ROLLBACKED !");
              new RollbackDemo().showRollBackedData(connection);
          }

       }catch(ClassNotFoundException | SQLException | IOException e){
           System.out.println(e.getMessage());
       }
    }
}
/*
DELETED SUCCESSFULLY
                 TID                 NAME          DESIGNATION
                 101                AARTI              Trainer
                 109                ANWAY                   SE
                 199               Yuvraj             TEAMLEAD
DO WANT TO ROLLBACK-1 OR COMMIT-0
1
DATA ROLLBACKED !
                 101                AARTI              Trainer
                 109                ANWAY                   SE
                 111              ANIRUDH              MANAGER
                 199               Yuvraj             TEAMLEAD

 */