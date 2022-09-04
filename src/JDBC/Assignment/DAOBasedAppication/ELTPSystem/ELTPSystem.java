package JDBC.Assignment.DAOBasedAppication.ELTPSystem;

import JDBC.Assignment.DAOBasedAppication.ELTPSystem.ConnectionMaker.ConnectionProvider;

import java.io.IOException;
import java.sql.SQLException;

public class ELTPSystem {
    public static void main(String[] args) {
        System.out.println("--------------------------------WELCOME TO ELTP SYSTEM---------------------------------------- ");
        try {
            // making connection to DB
            ConnectionProvider.connectionProvider();
            while(true) {
                new MenuELTP().menuELTP();
            }
        }catch (ClassNotFoundException |SQLException | IOException e ){
            System.out.println(e.getMessage());
        }
    }
}
/*
--------------------------------WELCOME TO ELTP SYSTEM----------------------------------------
----------------------------------------------------------------------------------------------
ENTER 1 FOR INSERT DATA :
ENTER 2 FOR SHOW DATA :
ENTER 3 FOR UPDATE DATA :
ENTER 4 FOR DELETE DATA :
ENTER 5 FOR SHOW ALL DATA :
ENTER 0 FOR EXIT :
----------------------------------------------------------------------------------------------
5
-------------------------------WELCOME TO VIEW-DATA WIZARD-------------------------------
-------------------------------------------------------------------------------
1101       REACT      20         RT   2022-09-11
1102       JAVA       15         AARTI   2022-09-11
-------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------
ENTER 1 FOR INSERT DATA :
ENTER 2 FOR SHOW DATA :
ENTER 3 FOR UPDATE DATA :
ENTER 4 FOR DELETE DATA :
ENTER 5 FOR SHOW ALL DATA :
ENTER 0 FOR EXIT :
----------------------------------------------------------------------------------------------
0
YOU HAVE BEEN LOGGED OUT SUCCESSFULLY !!
 */