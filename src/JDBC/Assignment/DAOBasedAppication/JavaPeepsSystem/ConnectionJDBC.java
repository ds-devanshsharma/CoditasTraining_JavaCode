package JDBC.Assignment.DAOBasedAppication.JavaPeepsSystem;

import JDBC.Assignment.DAOBasedAppication.ELTPSystem.ConnectionMaker.ConnectionProvider;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Another package's Connection
 public class ConnectionJDBC {

    private ConnectionJDBC() {
    }

    public static Connection getConnectionJDBC() throws SQLException, ClassNotFoundException {
        return ConnectionProvider.connectionProvider();
    }
}
