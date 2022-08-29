package JDBC.Day2;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Arrays;

public class BatchUpdateDemo {


    public static void main(String[] args) {
        Connection connection  =null;
        Statement statement = null ;
        PreparedStatement preparedStatement =null;
         String user ="root";
         String password = "Coditas@123";
        //
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connection
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DATABASE",user,password);
            //statement
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("?");
            //addBatch
//            statement.addBatch("INSERT INTO JAVA_PEEPS(I_ID,I_NAME,CITY) VALUES(11011,'DUBEY ','MH') ");
//
//            statement.addBatch("INSERT INTO JAVA_PEEPS VALUES(11089,'ABHISHEK','KOL' )");
            statement.addBatch("INSERT INTO JAVA_PEEPS VALUES(11090,'PRATEEK','UK' )");
//            statement.addBatch("INSERT INTO JAVA_PEEPS VALUES(11089,'USMAN','UP' )");
            statement.addBatch("DELETE FROM JAVA_PEEPS WHERE I_ID = 11111");
            statement.addBatch("UPDATE JAVA_PEEPS SET I_NAME ='ABHISHEK' WHERE I_ID = 11011");



            //executing batch
            int [] check =statement.executeBatch();
            if(check.length >0) System.out.println("BATCH AFFECTED DATABASE SUCCESSFULLY !");
            System.out.println(Arrays.toString(check));

        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
/*
BATCH AFFECTED DATABASE SUCCESSFULLY !
[1, 2, 2]
 */