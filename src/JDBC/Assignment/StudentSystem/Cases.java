package JDBC.Assignment.StudentSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Date;

public class Cases {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    BufferedReader reader ;

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
        preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE ID BETWEEN 20 AND 50");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%10d %10s %10s %10f %10s %10s \n",resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getFloat(4),
                    resultSet.getString(5),resultSet.getString(6));
        }
    }
    void takeInput(BufferedReader reader) throws IOException, SQLException {
        System.out.println("Enter ID :");
        preparedStatement.setInt(1,Integer.parseInt(reader.readLine()));
        System.out.println("Enter Name :");
        preparedStatement.setString(2,reader.readLine());
        System.out.println("Enter YEAR like TY/FY  : ");
        preparedStatement.setString(3,reader.readLine());
        System.out.println("Enter percentage :");
        preparedStatement.setFloat(4,Float.parseFloat(reader.readLine()));
        System.out.println("Enter City :  ");
        preparedStatement.setString(5,reader.readLine());
        System.out.println("Enter your Gender M/F :");
        preparedStatement.setString(6,reader.readLine());
        preparedStatement.addBatch();
    }
    void case4(Connection connection) throws SQLException, IOException {
        preparedStatement = connection.prepareStatement("INSERT INTO STUDENT_COPY VALUES (?,?,?,?,?,?)");
        reader = new BufferedReader(new InputStreamReader(System.in));
        boolean condition =true;
        do {
            System.out.println("DO YOU WANT TO ADD MORE DATA\n" +
                    "YES -1 \n" +
                    "NO  -0");
            int option = Integer.parseInt(reader.readLine());
            switch (option) {
                case 1:
                    takeInput(reader);
                    break;
                case 0:
                    preparedStatement.executeBatch();
                    System.out.println("YOU ARE OUT FROM ADD WIZARD !!");
                    condition = false;
                    break;
            }
        }while(condition);
    }
    void case4Update(Connection connection) throws SQLException {
        preparedStatement= connection.prepareStatement("UPDATE STUDENT_COPY SET NAME = 'MR'+NAME WHERE GENDER ='M'");
        preparedStatement.executeUpdate();
        preparedStatement=connection.prepareStatement("SELECT * FROM STUDENT_COPY");
        resultSet =preparedStatement.executeQuery();
        printer(resultSet);
    }
    void case4Remove(Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM  STUDENT_copy WHERE YEAR = 'FY' ");
        preparedStatement.executeUpdate();
        //for printing
        preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT_COPY ");
        resultSet = preparedStatement.executeQuery();
        printer(resultSet);
    }
    //this is basically helper method to print Record After any operation
    static void printer(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            System.out.printf("%10d %10s %10s %10f %10s %5s",resultSet.getInt(1),
                    resultSet.getString(2),resultSet.getString(3),
                    resultSet.getFloat(4),resultSet.getString(5),
                    resultSet.getString(6));
        }
    }
}
