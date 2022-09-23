package com.Collabration.FirstProject.FirstProject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionImplementation implements ConnectionNeeds{
    static Connection connection;
    private ConnectionImplementation(){}
    public static Connection ConnectionImplementation() throws SQLException {
        if(connection==null){
            connection= DriverManager.getConnection(url,user,password);
        }
        return connection;
    }
}
