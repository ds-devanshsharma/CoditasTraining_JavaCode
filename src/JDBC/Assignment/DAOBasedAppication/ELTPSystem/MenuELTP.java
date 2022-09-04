package JDBC.Assignment.DAOBasedAppication.ELTPSystem;

import JDBC.Assignment.DAOBasedAppication.ELTPSystem.ImplementationELTP.DaoImplementationELTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuELTP {
    public static BufferedReader reader ;
    void menuELTP() throws IOException {
        System.out.println("----------------------------------------------------------------------------------------------" +
                "\nENTER 1 FOR INSERT DATA :\n" +
                "ENTER 2 FOR SHOW DATA :\n" +
                "ENTER 3 FOR UPDATE DATA :\n" +
                "ENTER 4 FOR DELETE DATA : \n" +
                "ENTER 5 FOR SHOW ALL DATA :\n" +
                "ENTER 0 FOR EXIT : \n" +
                "----------------------------------------------------------------------------------------------");
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            switch (Integer.parseInt(reader.readLine())) {
                case 1:
                    new DaoImplementationELTP().insertData();
                    break;
                case 2:
                    new DaoImplementationELTP().showData();
                    break;
                case 3:
                    new DaoImplementationELTP().updateData();
                    break;
                case 4:
                    new DaoImplementationELTP().deleteData();
                    break;
                case 5:
                    new DaoImplementationELTP().showAllData();
                    break;
                case 0 :
                    System.out.println("YOU HAVE BEEN LOGGED OUT SUCCESSFULLY !!");
                    System.exit(0);
                default:
                    System.out.println("SOMETHING WENT WRONG !!");
                    menuELTP();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            menuELTP();
        }
    }
}
