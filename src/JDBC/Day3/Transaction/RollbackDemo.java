package JDBC.Day3.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class RollbackDemo {
    BufferedReader reader ;
    static ResultSet resultSet;
    Statement preparedStatement ;
    static void  printer(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){

            System.out.format("%20d %20s %20s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
        }
    }
    void showRollBackedData(Connection connection) throws SQLException {
        preparedStatement = connection.createStatement();
        resultSet =preparedStatement.executeQuery("SELECT * FROM TEACHER ");
        printer(resultSet);
    }
    void rollback(Connection connection) throws SQLException, IOException {
        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//        System.out.println("Enter Teacher ID : ");
//        reader =new BufferedReader(new InputStreamReader(System.in));
//        preparedStatement.setInt(1,Integer.parseInt(reader.readLine()));
        int check =preparedStatement.executeUpdate("DELETE FROM TEACHER WHERE TID = 111");
        if(check !=0 ) System.out.println("DELETED SUCCESSFULLY ");
//        preparedStatement= connection.prepareStatement("SELECT * FROM TEACHER ");
        resultSet =preparedStatement.executeQuery("SELECT * FROM TEACHER ");
        //formatting
        ResultSetMetaData rmd = resultSet.getMetaData();
        System.out.format("%20s %20s %20s\n",rmd.getColumnName(1),rmd.getColumnName(2),rmd.getColumnName(3));

        printer(resultSet);

    }
}
