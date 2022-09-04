package JDBC.Assignment.DAOBasedAppication.JavaPeepsSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface JavaPeep {
    void insertData(Connection connection) throws SQLException, IOException;
    void showData(Connection connection) throws SQLException;
    void updateData(Connection connection);
    void deleteData(Connection connection) throws SQLException, IOException;
    void showAllData(Connection connection) throws SQLException;
}
