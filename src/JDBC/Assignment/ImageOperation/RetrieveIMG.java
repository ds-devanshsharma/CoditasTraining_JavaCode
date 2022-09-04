package JDBC.Assignment.ImageOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveIMG {
    Statement statement ;
    ResultSet resultSet ;
    public void retrieveImg(Connection connection) throws SQLException, IOException {
           try {
               statement = connection.createStatement();
               resultSet = statement.executeQuery("SELECT IMG FROM GALLERY WHERE IMG_ID =2 ");

               FileOutputStream outputStream = new FileOutputStream("C:\\Users\\coditas\\IdeaProjects\\" +
                       "CoditasTraining_JavaCode\\src\\JDBC\\Assignment\\ImageOperation\\RetrievedIMG.jpg");
               while (resultSet.next()) {
                   outputStream.write(resultSet.getBytes(1));
               }
               if(resultSet!= null) System.out.println("IMG RETRIEVED SUCCESSFULLY !!");
               outputStream.close();
           }catch (Exception e) {
               System.out.println(e.getMessage());
           }

    }
}
