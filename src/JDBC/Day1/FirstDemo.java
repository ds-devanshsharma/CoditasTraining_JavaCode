package JDBC.Day1;

import org.w3c.dom.ls.LSOutput;

import javax.sql.StatementEvent;
import java.sql.*;

import static java.lang.Class.forName;

public class FirstDemo {

    public static void main(String[] args) {

       try {
           // DriverManager
           Class.forName("com.mysql.jdbc.Driver");
           // Connection
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_database","root","Coditas@123");
           // statement
            Statement statement = connection.createStatement();
           System.out.println("Using normal Statement : ");
            //prepareQuery

           // resultSet
//            int check=statement.executeUpdate(
//                   "INSERT INTO JAVA_PEEPS(I_ID , I_NAME,CITY ) VALUES(11057,'ADITYA ','PUNE')");
//           if(check!=0) System.out.println("Data Inserted Successfully !!!");
//           ResultSet resultSet = statement.executeQuery("SELECT * FROM JAVA_PEEPS");
           int  resultSet1 = statement.executeUpdate("UPDATE JAVA_PEEPS SET CITY ='UK' WHERE I_ID = 11067" );
           if(resultSet1>0) System.out.println("DATA Updated  SUCCESSFULLY !!");
           // getting another resultSet to fetch data out from database executeQuery()
           ResultSet resultSet = statement.executeQuery("SELECT * FROM JAVA_PEEPS");
           while(resultSet.next()){
                   System.out.println(resultSet.getInt(1) +" " + resultSet.getString(2)+" "+resultSet.getString(3));
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
}
/*
fetching data out from DATABASE (JAVA_PEEPS table)
Using normal Statement :
11056 DEVANSH SHARMA  KANPUR
11067 ANUJ DEHRADOON

 */
/*
output after insertion
Using normal Statement :
11056 DEVANSH SHARMA  KANPUR
11067 ANUJ DEHRADOON
11057 ADITYA  PUNE
 */
/*
output after deletion :
Using normal Statement :
11067 ANUJ DEHRADOON
11057 ADITYA  PUNE

output after updation :
 Using normal Statement :
DATA Updated  SUCCESSFULLY !!
11067 ANUJ UK
11057 ADITYA  PUNE*/