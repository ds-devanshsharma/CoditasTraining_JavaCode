package JDBC.Assignment.DAOBasedAppication.ELTPSystem.ConnectionMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection connection ;

    private ConnectionProvider() {
    }
    public static Connection connectionProvider() throws SQLException, ClassNotFoundException {
        Class.forName(ConnectionMaker.driver);
        if (connection == null)connection = DriverManager.getConnection(ConnectionMaker.url, ConnectionMaker.user, ConnectionMaker.password);
            return connection;
    }
}
