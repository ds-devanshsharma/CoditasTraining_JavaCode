package Employee.Registration.DAO;

import Employee.Registration.model.Employee;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class EmployeeDAO {
    PreparedStatement preparedStatement ;
  public int registerEmployee( Employee employee){
    int result=0;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/SERVLET_DATABASE","root","Coditas@123");
        // statement
        preparedStatement=connection.prepareStatement("INSERT INTO EMPLOYEE_Management(" +
                "ID,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,ADDRESS,CONTACT) VALUES" +
                "(?,?,?,?,?,?,?)");
        preparedStatement.setInt(1,employee.getEmpID());
        preparedStatement.setString(2,employee.getFirstName());
        preparedStatement.setString(3,employee.getLastName());
        preparedStatement.setString(4,employee.getUserName());
        preparedStatement.setString(5,employee.getPassword());
        preparedStatement.setString(6,employee.getAddress());
        preparedStatement.setLong(7,employee.getContact());
        result = preparedStatement.executeUpdate();
    }catch(ClassNotFoundException | SQLException e){
        System.out.println(e.getMessage());
    }
    return result;
  }
}
