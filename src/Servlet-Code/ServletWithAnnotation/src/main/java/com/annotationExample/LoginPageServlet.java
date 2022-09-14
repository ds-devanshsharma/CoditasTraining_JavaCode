package com.annotationExample;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //setting responseType which will display on browser
        resp.setContentType("text/html");

        //getting ready your Writer
        PrintWriter out = resp.getWriter();

        ServletConfig config = getServletConfig();
        out.println("<h1><center>"+config.getInitParameter("LoginServletConfig")+"</center></h1><br><hr>");
        //writing on browser
        out.println("<h2>WELCOME TO HOMEPAGE !! </h2>\n" +
                "UserName : "+ req.getParameter("username"));

        ServletContext application = getServletContext();
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;

        try{
            Class.forName(application.getInitParameter("Driver"));
            connection = DriverManager.getConnection(application.getInitParameter("Url"),
                    application.getInitParameter("Username"),"Coditas@123");
            preparedStatement =connection.prepareStatement("SELECT * FROM JAVA_PEEPS ");
            resultSet =preparedStatement.executeQuery();
            out.println("<Table border ='2'>" +
                    "<tr>" +
                    "<th> ID </th>" +
                    "<th> Name</th>" +
                    "<th>City</th>" +
                    "<th>Education</th>" +
                    "</tr>");

            while(resultSet.next()){
                out.println("<tr><td>"+resultSet.getInt(1)+"</td><td>"+resultSet.getString(2)+"</td>"+
                        "<td>"+resultSet.getString(3)+"</td>"+"<td>"+resultSet.getString(4)+"</td></tr>");

            }
            out.println("</Table>");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        out.println("\n<a href = 'Bye' target ='_blank'>GO Back</a>");

    }
}
