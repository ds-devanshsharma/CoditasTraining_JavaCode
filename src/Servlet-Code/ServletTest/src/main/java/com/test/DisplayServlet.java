package com.test;

import com.mysql.cj.protocol.Resultset;
import com.test.JDBCConnector.ConnectionImplementation;

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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");

            PrintWriter out = resp.getWriter();
            ServletContext application =getServletContext();
            connection = ConnectionImplementation.getConnectionForDB();
            preparedStatement = connection.prepareStatement("SELECT * FROM REGISTRATION where username =? and password = ? ");
            preparedStatement.setString(1,req.getParameter("username"));
            preparedStatement.setString(2,req.getParameter("password"));
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                out.println("<h1><center>UserData</center></h1><hr><br>" +
                        "<center><table border= 1>" +
                        "<tr><th>Username</th>" +
                        "<th>Contact</th>" +
                        "<th>City</th>" +
                        "<th>Education</th></tr>" +
                        "<tr><td> "+resultSet.getString(1)+"</td>" +
                        "<td>"+resultSet.getString(3)+"</td>" +
                        "<td>"+resultSet.getString(4)+"</td>" +
                        "<td>"+resultSet.getString(5)+"</td>" +
                        "</tr>" +
                        "</table></center>");
            }
            else{
                out.println("<h1><center>Record not found !!</center></h1>");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
