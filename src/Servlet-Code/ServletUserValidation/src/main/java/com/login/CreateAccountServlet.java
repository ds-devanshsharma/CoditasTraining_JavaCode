package com.login;

import com.login.JDBCConnector.*;
import com.mysql.cj.jdbc.JdbcConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class CreateAccountServlet extends HttpServlet {
    Connection connection;
    PreparedStatement preparedStatement;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
//        ServletContext application = getServletContext();
//        PrintWriter out = (PrintWriter)application.getAttribute("out");

        try {
        connection = ConnectionImplementation.getConnectionOfDB();
        // YOU HAVE TO SET CONTENT TYPE
           resp.setContentType("text/html");

           preparedStatement = connection.prepareStatement("INSERT INTO user_login_details values(?,?)");
           preparedStatement.setString(1,req.getParameter("username"));
           preparedStatement.setString(2,req.getParameter("password"));
           if(preparedStatement.executeUpdate()!=0) {
               out.println("<h2>Account created successfully !!</h2><hr><br>" +
                       "<a href= 'LoginForm.html'>Now login here</a> ");
           }else{
               //else logic is inside Catch block
           }
       }catch(SQLException e){
           out.println("<h2>Username Already Exist !!</h2><hr><br>" +
                   "<a href= 'Register.html'>Try again </a> ");
            RequestDispatcher dispatcher = req.getRequestDispatcher("Register.html");
            dispatcher.include(req,resp);

           System.out.println(e.getMessage());
       }
    }
}
