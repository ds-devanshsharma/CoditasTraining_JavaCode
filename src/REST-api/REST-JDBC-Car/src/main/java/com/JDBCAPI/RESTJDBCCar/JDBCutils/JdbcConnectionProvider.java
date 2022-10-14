package com.JDBCAPI.RESTJDBCCar.JDBCutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionProvider implements JdbcNeeds{
    private JdbcConnectionProvider(){}
    private static Connection connection ;
    public static Connection JdbcConnectionProviderMethod()  {
        try{if(connection ==null){
            Class.forName(driver_class);
            connection = DriverManager.getConnection(url,user,password);
        }
        }catch (ClassNotFoundException | SQLException e ){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
