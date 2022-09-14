package com.login.JDBCConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionImplementation implements ConnectionNeed{
    static Connection connection;
    private ConnectionImplementation(){
    }
    public static Connection getConnectionOfDB(){
        if(connection==null){
            try{
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,password);
            }catch (ClassNotFoundException | SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}
