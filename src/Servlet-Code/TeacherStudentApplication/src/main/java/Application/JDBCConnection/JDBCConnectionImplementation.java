package Application.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionImplementation implements ConnectionNeeds{
    public static Connection connection;
    private JDBCConnectionImplementation(){}
    public static Connection getJDBCConnection(){
        try {
            if (connection == null) {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            }
        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
