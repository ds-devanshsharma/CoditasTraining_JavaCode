package JDBC.Assignment.ELTPSystem.DaoELTP;

import java.io.IOException;
import java.sql.SQLException;

public interface DaoELTP {
    void insertData() throws SQLException, IOException;
    void showData() throws SQLException, IOException;
    void updateData() throws IOException, SQLException;
    void deleteData() throws SQLException, IOException;
    void showAllData() throws SQLException;
}
