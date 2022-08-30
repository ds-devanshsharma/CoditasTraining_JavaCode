package JDBC.Day3.OneToManyRelation;

import java.sql.*;

/**
 * 8)Create Table Teacher-Student with relation 1-M ie. one Teacher teaches Many
 * Student.(Training)
 * case1=>display data teacher wise
 * teacher="Lata" then display student of only lata
 * Query :
 * SELECT TEACHER.NAME,STUDENT.NAME FROM STUDENT JOIN TEACHER ON TEACHER.TID = STUDENT.TID;
 */
public class Ques8 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DATABASE",
                    "root","Coditas@123");
            //statement
            statement =connection.createStatement();
            resultSet =statement.executeQuery("SELECT TEACHER.NAME,STUDENT.NAME FROM STUDENT JOIN TEACHER " +
                    "ON TEACHER.TID = STUDENT.TID; ");
            if(resultSet.next()) System.out.println("RECORD FETCHED FROM DB :\n" +
                    "------------------------------------------------------------");
            while(resultSet.next()){
                System.out.format("%-10s %-10s\n", resultSet.getString(1),resultSet.getString(2));
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            connection.close();
            resultSet.close();
            statement.close();
        }
    }
}
/*
RECORD FETCHED FROM DB :
------------------------------------------------------------
AARTI      DEVANSH
AARTI      HIMANSHU
AARTI      NEGI
ANWAY      SIMRAN
ANIRUDH    PRIYANKA
Yuvraj     SATYAM
Yuvraj     MANISH
 */