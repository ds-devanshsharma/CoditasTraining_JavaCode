package JDBC.Assignment.ImageOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImg {
    PreparedStatement preparedStatement;
    void addingImage(Connection connection) throws SQLException, IOException {
        //file
        FileInputStream fileInputStream =new  FileInputStream("C:\\Users\\coditas\\Pictures\\Screenshots\\IMG.png");
        preparedStatement = connection.prepareStatement("INSERT INTO GALLERY VALUES(?,?)");
        preparedStatement.setInt(1,1);
        preparedStatement.setBlob(2,fileInputStream);
        //executing statement
       int check = preparedStatement.executeUpdate();
       if(check !=0 ) System.out.println("IMG ADDED SUCCESSFULLY !!");
    }
}
