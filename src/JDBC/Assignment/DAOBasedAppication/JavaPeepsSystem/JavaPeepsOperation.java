package JDBC.Assignment.DAOBasedAppication.JavaPeepsSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 class JavaPeepsOperation implements JavaPeep{
    PreparedStatement preparedStatement ;
    BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    JavaPeepsPOJO javaPeepsPOJO ;
    ResultSet resultSet ;
    @Override
    public void insertData(Connection connection) throws SQLException, IOException {
        //preparedStatement
        preparedStatement =connection.prepareStatement("INSERT INTO JAVA_PEEPS VALUES(?,?,?,?)");
        boolean condition1 =true;
        int count =0;
        while(condition1) {
            javaPeepsPOJO = takeInput(reader);

            preparedStatement.setInt(1, javaPeepsPOJO.getInternID());
            preparedStatement.setString(2, javaPeepsPOJO.getName());
            preparedStatement.setString(3, javaPeepsPOJO.getCity());
            preparedStatement.setString(4, javaPeepsPOJO.getEducation());
            preparedStatement.addBatch();
            count++;
            System.out.println("DO YOU WANT TO ADD MORE DATA \n" +
                    "ENTER 1 - YES\n" +
                    "ENTER 0 - NO");
            if(Integer.parseInt(reader.readLine())==0) condition1 = false;
        }
        //executing prepareStatement
        if(preparedStatement.executeBatch().length !=0) System.out.println(count +" RECORDS ADDED SUCCESSFULLY !!");

    }
    //helper UserInput Method
     JavaPeepsPOJO takeInput(BufferedReader reader) throws IOException {
        try {
            javaPeepsPOJO = new JavaPeepsPOJO();
            System.out.println("ENTER INTERN ID :");
            javaPeepsPOJO.setInternID(Integer.parseInt(reader.readLine()));
            System.out.println("ENTER YOUR NAME :");
            javaPeepsPOJO.setName(reader.readLine());
            System.out.println("ENTER YOUR CITY :");
            javaPeepsPOJO.setCity(reader.readLine());
            System.out.println("ENTER YOUR LAST EDUCATION :");
            javaPeepsPOJO.setEducation(reader.readLine());

        }catch (Exception e ){
            System.out.println(e.getMessage());
            System.out.println("ENTER AGAIN !!");
            takeInput(reader);
        }
        return javaPeepsPOJO;
    }
    //Helper method to print data collected in ResulSet
    static void printer(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
//            System.out.println("__________________________________________________________________________________");
            System.out.printf("%10d %10s %10S %10s",resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4)+"\n");
            System.out.println("__________________________________________________________________________________");
        }
    }
    @Override
    public void showData(Connection connection) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT * FROM JAVA_PEEPS WHERE I_ID = ?", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        System.out.println("__________________________________________________________________________________\n" +
                "WELCOME TO VIEW RECORD WIZARD !!\n" +
                "__________________________________________________________________________________");
        try {
            System.out.println("ENTER ID :");
            preparedStatement.setInt(1, Integer.parseInt(reader.readLine()));
            //executing preparedStatement
            resultSet = preparedStatement.executeQuery();

            //calling dataPrinter() helper Method
            printer(resultSet);
        }
        catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG !!!");
            System.out.println(e.getMessage());
            showData(connection);
        }
        resultSet.beforeFirst();
        if(!resultSet.next()) System.out.println("NO RECORD FOUND !!");

    }


    @Override
    public void updateData(Connection connection) {

    }

    @Override
    public void
    deleteData(Connection connection) throws SQLException, IOException {
        System.out.println("_______________________________________________________________________\n" +
                "WELCOME RECORD DELETION WIZARD !!");
        preparedStatement = connection.prepareStatement("DELETE FROM JAVA_PEEPS WHERE I_ID = ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
        boolean condition1 =true;
//        int count =0;
        int check=0;
        try {
//            while(condition1) {

                System.out.println("ENTER ID :");
                preparedStatement.setInt(1, Integer.parseInt(reader.readLine()));
                check =preparedStatement.executeUpdate();
////                count++;
//                System.out.println("DO YOU WANT TO DELETE MORE DATA \n" +
//                        "ENTER 1 - YES\n" +
//                        "ENTER 0 - NO");
//                if (Integer.parseInt(reader.readLine()) == 0) {
//                    condition1 = false;
//                    int check[] =preparedStatement.executeBatch();
                    if(check!=0) System.out.println(" RECORD DELETED SUCCESSFULLY !! ");
                    else{
                        System.out.println("RECORD NOT FOUND !! ");
//                        count =0;
                    }

//                }
//            }
        }catch (Exception e) {
               System.out.println("SOMETING WENT WRONG !!!");
               System.out.println(e.getMessage());
//               count =0;
               deleteData(connection);
        }


    }

    @Override
    public void showAllData(Connection connection) throws SQLException {
        System.out.println("__________________________________________________________________________________\n" +
                "WELCOME TO VIEW RECORD WIZARD !!\n" +
                "__________________________________________________________________________________");
        preparedStatement = connection.prepareStatement("SELECT * FROM JAVA_PEEPS",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet = preparedStatement.executeQuery();
        printer(resultSet);
        resultSet.beforeFirst();
        if(!resultSet.next()) System.out.println("NO RECORD FOUND !!");
    }
}
