package JDBC.Assignment.ELTPSystem.ImplementationELTP;

import JDBC.Assignment.ELTPSystem.DaoELTP.DaoELTP;
import static JDBC.Assignment.ELTPSystem.ConnectionMaker.ConnectionProvider.connection;
import JDBC.Assignment.ELTPSystem.PojoELTP.PojoELTP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class DaoImplementationELTP implements DaoELTP {
PreparedStatement preparedStatement ;
BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
PojoELTP pojoELTP;
ResultSet resultSet;
// takeInput helper method
    void takeInput() {
        pojoELTP = new PojoELTP();
        try {
            System.out.println("ENTER BATCH-ID :");
            pojoELTP.setBatchID(Integer.parseInt(reader.readLine()));
            System.out.println("ENTER BATCH-NAME :");
            pojoELTP.setBatchName(reader.readLine());
            System.out.println("ENTER STUDENT-COUNT :");
            pojoELTP.setStudentCount(Integer.parseInt(reader.readLine()));
            System.out.println("ENTER TRAINER-NAME :");
            pojoELTP.setTrainerName(reader.readLine());
            System.out.println("ENTER JOIN-DATE : ");
            pojoELTP.setJoinDate(reader.readLine());
        }
        catch (Exception e){
            System.out.println("INPUT MIS-MATCHED !!");
            takeInput();
        }
    }
    public void insertData() throws SQLException {
        takeInput();
        preparedStatement =connection.prepareStatement("INSERT INTO ELTP VALUES(?,?,?,?,?)");
        preparedStatement.setInt(1,pojoELTP.getBatchID());
        preparedStatement.setString(2,pojoELTP.getBatchName());
        preparedStatement.setInt(3,pojoELTP.getStudentCount());
        preparedStatement.setString(4,pojoELTP.getTrainerName());
        preparedStatement.setDate(5,Date.valueOf(pojoELTP.getJoinDate()));
        if(preparedStatement.executeUpdate()!=0) System.out.println("RECORD ADDED SUCCESSFULLY !!");
    }

    @Override
    public void showData() throws SQLException, IOException {
        System.out.println("---------------------------------WELCOME TO VIEW-DATA WIZARD---------------------------------");
        preparedStatement = connection.prepareStatement("SELECT * FROM ELTP WHERE BATCH_ID = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("ENTER BATCH-ID : ");
        preparedStatement.setInt(1,Integer.parseInt(reader.readLine()));
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            resultSet.beforeFirst();
            printer(resultSet);
        }
        else System.out.println("----------------------------------RECORD NOT FOUND------------------------------------------ ");
    }

    private void printer(ResultSet resultSet) throws SQLException {
//        ResultSetMetaData data = resultSet.getMetaData();
        System.out.println("-------------------------------------------------------------------------------");
        while (resultSet.next()) {
            System.out.printf("%-10d %-10s %-10d %10s\n", resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getString(4)+"   "+ resultSet.getDate(5));
        }//There is some issue in printing date console Q- Which specifier I should use with getDate() ?
        System.out.println("-------------------------------------------------------------------------------");
    }

    @Override
    public void updateData() throws IOException, SQLException {
        System.out.println("-------------------------------WELCOME TO UPDATION WIZARD-------------------------------");
        boolean condition =true;
        System.out.println("ENTER BATCH-ID TO UPDATE RECORD : ");
        int batchID = Integer.parseInt(reader.readLine());
        while(condition){
            System.out.println("""
                    PRESS 1 TO UPDATE BATCH-NAME :\s
                    PRESS 2 TO UPADTE STUDENT-COUNT :
                    PRESS 3 TO UPDATE TRAINER-NAME :
                    PRESS 4 TO UPDATE JOIN-DATE :\s
                    PRESS 0 TO GO BACK \s""");
            switch (Integer.parseInt(reader.readLine())) {
                case 1 -> {
                    preparedStatement = connection.prepareStatement("UPDATE ELTP SET BATCH_NAME = ? WHERE BATCH_ID = ?");
                    System.out.println("ENTER NEW BATCH-NAME : ");
                    preparedStatement.setString(1, reader.readLine());
                    preparedStatement.setInt(2, batchID);
                    if (preparedStatement.executeUpdate() > 0) System.out.println("RECORD UPDATED SUCCESSFULLY !!");
                }
                case 2 -> {
                    preparedStatement = connection.prepareStatement("UPDATE ELTP SET STUDENT_COUNT = ? WHERE BATCH_ID = ? ");
                    System.out.println("ENTER NEW STUDENT-COUNT : ");
                    preparedStatement.setInt(1, Integer.parseInt((reader.readLine())));
                    preparedStatement.setInt(2, batchID);
                    if (preparedStatement.executeUpdate() > 0) System.out.println("RECORD UPDATED SUCCESSFULLY !!");
                }
                case 3 -> {
                    preparedStatement = connection.prepareStatement("UPDATE ELTP SET TRAINER_NAME = ? WHERE BATCH_ID = ?");
                    System.out.println("ENTER NEW TRAINER-NAME : ");
                    preparedStatement.setString(1, reader.readLine());
                    preparedStatement.setInt(2, batchID);
                    if (preparedStatement.executeUpdate() > 0) System.out.println("RECORD UPDATED SUCCESSFULLY !!");
                }
                case 0 -> {
                    condition = false;
                    System.out.println("YOU ARE OUT FROM UPDATION WIZARD !!");
                }
            }
        }
    }

    @Override
    public void deleteData() throws SQLException, IOException {
        System.out.println("-------------------------------WELCOME TO DELETION WIZARD-------------------------------");

        preparedStatement= connection.prepareStatement("DELETE FROM ELTP WHERE BATCH_ID  = ?");
        System.out.println("ENTER BATCH_ID : ");
        preparedStatement.setInt(1,Integer.parseInt(reader.readLine()));
        if(preparedStatement.executeUpdate()>0) System.out.println("RECORD DELETED SUCCESSFULLY !!!");
        else System.out.println("----------------------------------RECORD NOT FOUND------------------------------------------ ");
    }

    @Override
    public void showAllData() throws SQLException {
        System.out.println("-------------------------------WELCOME TO VIEW-DATA WIZARD-------------------------------");

        preparedStatement = connection.prepareStatement("SELECT * FROM ELTP ",
                ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            resultSet.beforeFirst();
            printer(resultSet);
        }
        else System.out.println("-------------------------------RECORD NOT FOUND--------------------------------------- ");
    }
}
