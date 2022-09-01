package JDBC.Assignment.JavaPeeps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class JavaPeepsMenu {
    public static BufferedReader reader  = null;
    static void operationMenu(Connection connection) throws IOException {

        System.out.println("__________________________________________________________________________________\n" +
                "Enter 1 TO INSERT DATA INTO RECORD :\n" +
                "ENTER 2 TO SHOW DATA :\n" +
                "ENTER 3 TO UPDATE DATA :\n" +
                "ENTER 4 TO DELETE DATA :\n" +
                "ENTER 5 TO SHOW ALL DATA FROM RECORD :\n" +
                "ENTER 0 TO EXIT \n" +
                "__________________________________________________________________________________");
        reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int option =Integer.parseInt(reader.readLine());
            switch (option){
                case 0 :
                    System.out.println("YOU HAVE LOGGED OUT SUCCESSFULLY !!");
                    System.exit(0);
                case 1 :
                    new JavaPeepsOperation().insertData(connection);
                    break;
                case 2 :
                    new JavaPeepsOperation().showData(connection);
                    break;
                case 3 :
                    new JavaPeepsOperation().updateData(connection);

                case 4 :
                    new JavaPeepsOperation().deleteData(connection);
                    break;
                case 5 :
                    new JavaPeepsOperation().showAllData(connection);
                    break;
                default:
                    System.out.println("THIS IS NOT CORRECT CHOICE FROM MENU !!");
            }
        }catch (Exception e ){
            System.out.println(e.getMessage());
            System.out.println(" INPUT MIS-MATCHED !! ENTER AGAIN !!\n" +
                    "______________________________________________________________________");
            operationMenu(connection);
        }

    }
}
