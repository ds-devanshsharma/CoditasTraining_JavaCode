package JDBCConnection;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionImplementation implements ConnectionNeeds{
    public static Connection connection;
   private ConnectionImplementation(){

    }
    public static Connection getJDBCConnection(){
       try {
           if (connection == null) {
               Class.forName(driver);
               connection= DriverManager.getConnection(url,user,password);
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return connection;
    }
}
