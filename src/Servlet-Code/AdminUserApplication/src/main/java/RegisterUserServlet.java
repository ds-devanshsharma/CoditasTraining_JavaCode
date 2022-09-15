import JDBCConnection.ConnectionImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
    PreparedStatement preparedStatement;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           resp.setContentType("text/html");
           PrintWriter out = resp.getWriter();
           preparedStatement = ConnectionImplementation.getJDBCConnection()
                   .prepareStatement("INSERT INTO USER VALUES(?,?,?,?) ");
           preparedStatement.setInt(1,Integer.parseInt(req.getParameter("id")));
           preparedStatement.setString(2,req.getParameter("name"));
           preparedStatement.setString(3,req.getParameter("city"));
           preparedStatement.setString(4,req.getParameter("password"));
           if(preparedStatement.executeUpdate()!=0) {
               out.println("RecordAdded Successfully!!");
               req.getRequestDispatcher("userDisplay").include(req,resp);
           }
       }catch(Exception e ){
           System.out.println(e.getMessage());
       }
    }
}
