package JDBC.Assignment.EmployeeSystem;

import java.sql.Connection;
import java.sql.DriverManager;

import static JDBC.Assignment.EmployeeSystem.EmployeeSystem.preparedStatement;
import static JDBC.Assignment.EmployeeSystem.EmployeeSystem.reader;

public class Menu {
    void Menu(Connection connection) throws Exception {
        System.out.println("Enter 1 for Adding DATA !\n" +
                            "Enter 2 for Showing DATA\n" +
                            "Enter 0 for Exit from MENU ");
        System.out.println("___________________________________________________________________________");
            int option =Integer.parseInt(reader.readLine());
            switch (option) {
                case 1 : new EmployeeSystem().addData(connection);
                         break;
                case 2 : new EmployeeSystem().showData(connection);
                         break;
                case 0 :
                    System.out.println("YOU HAVE LOGGED OUT SUCCESSFULLY !!");
                    System.exit(0);
            }
            int[] check = preparedStatement.executeBatch();
            if(check.length>0) System.out.println("DATA ADDED SUCCESSFULLY !!");
        System.out.println("___________________________________________________________________________");
    }
    public static void main(String[] args) {
        Connection connection= null;
        int condition =1;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            //connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC_DATABASE","root","Coditas@123");
            while(condition!=0) {
                new Menu().Menu(connection);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
