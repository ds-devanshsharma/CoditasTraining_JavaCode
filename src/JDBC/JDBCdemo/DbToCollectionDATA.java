package JDBC.JDBCdemo;
import  JDBC.Assignment.ELTPSystem.ConnectionMaker.*;
import JDBC.Assignment.JavaPeeps.JavaPeepsPOJO;

import static JDBC.Assignment.ELTPSystem.ConnectionMaker.ConnectionProvider.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DbToCollectionDATA {
    List<JavaPeepsPOJO> list = new ArrayList<>();
    void resultSetToCollection(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            list.add(new JavaPeepsPOJO(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4)));
        }
        //printing
        list.stream().
                forEach(System.out::println);
    }

    public static void main(String[] args) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null ;
        try{
            connection =ConnectionProvider.connectionProvider();
            preparedStatement = connection.prepareStatement("SELECT * FROM JAVA_PEEPS ");
            resultSet = preparedStatement.executeQuery();
            new DbToCollectionDATA().resultSetToCollection(resultSet);

        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
