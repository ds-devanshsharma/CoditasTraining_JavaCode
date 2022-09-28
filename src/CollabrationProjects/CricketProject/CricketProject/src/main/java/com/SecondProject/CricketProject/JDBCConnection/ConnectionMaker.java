package com.SecondProject.CricketProject.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMaker implements ConnectionNeed{
    static Connection connection ;
    private ConnectionMaker(){}
    public static Connection getJDBCConnectionFromConnectionMaker() throws ClassNotFoundException, SQLException {
        if(connection==null){
            Class.forName(driver_class);
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}
