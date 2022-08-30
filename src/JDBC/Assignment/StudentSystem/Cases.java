package JDBC.Assignment.StudentSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cases {
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    void addGenderColumn(Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "ALTER TABLE STUDENT ADD COLUMN GENDER VARCHAR(1) ");
        int check = preparedStatement.executeUpdate();
        if (check != 0) System.out.println("COLUMN ADDDED SUCCESSFULLY !!");
    }

    void fetchCase1(Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE YEAR = 'FY' AND PERCENTAGE > 70 ");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " + resultSet.getFloat(4) + " " +
                    resultSet.getString(5) + " " + resultSet.getString(6));
        }
    }

    void fetchCase3(Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID >=20 and ID <=50");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " + resultSet.getFloat(4) + " " +
                    resultSet.getString(5) + " " + resultSet.getString(6));
        }
    }
}
