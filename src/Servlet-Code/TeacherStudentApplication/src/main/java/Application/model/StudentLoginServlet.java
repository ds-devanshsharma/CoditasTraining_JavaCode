package Application.model;

import Application.JDBCConnection.JDBCConnectionImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/studentLogin")
public class StudentLoginServlet extends HttpServlet {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
       try{
           preparedStatement = JDBCConnectionImplementation.getJDBCConnection()
                   .prepareStatement("SELECT * FROM Student WHERE USERNAME =? AND PASSWORD=?");
           preparedStatement.setString(1,req.getParameter("username"));
           preparedStatement.setString(2,req.getParameter("password"));
           HttpSession session = req.getSession();
           session.setAttribute("username",req.getParameter("username"));
           resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               //setting ID in session
               session.setAttribute("id",resultSet.getInt(1));
               resp.sendRedirect("studentDisplay");
           }
           else{
               out.println("<h3>Invalid UserName/Password !!</h3>");
               req.getRequestDispatcher("StudentLogin.html").include(req,resp);
           }
        }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

}