package com.login;

import javax.servlet.RequestDispatcher;
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
public class ValidateServlet extends HttpServlet {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // set contentType
        resp.setContentType("text/html");
        //getting ready writer
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        //making username globally available by using ServletContext Interface
        ServletContext application = getServletConfig().getServletContext();
        application.setAttribute("username",username);
        application.setAttribute("password",req.getParameter("password"));

        // PrintWriter global
        application.setAttribute("out",out);
        //checking password valid or not
        checkPassword(username,req,resp);
    }
     void checkPassword(String username ,HttpServletRequest req,HttpServletResponse resp)  {
        try{
            ServletContext application = getServletContext();
            PrintWriter out = (PrintWriter)application.getAttribute("out");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DATABASE",
                    "root","Coditas@123");
            preparedStatement = connection.prepareStatement("SELECT * FROM USER_LOGIN_DETAILS WHERE USERNAME = ? ");
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                //if username not matched
                out.println("<h2><center> Wrong UserName !!</center><h2><hr><br>" +
                        "<a href='LoginForm.html'>Go Back</a>");
                RequestDispatcher dispatcher = req.getRequestDispatcher("LoginForm.html");
                dispatcher.include(req,resp);
            }
            else if(req.getParameter("password").equals(resultSet.getString(2))){
                // if password matched
                RequestDispatcher requestDispatcher=req.getRequestDispatcher("success");
                requestDispatcher.forward(req,resp);
            }
            else{
                out.println("<h2><center> Wrong Password !</center></h2><hr><br>" +
                        "<a href='LoginForm.html'> Go back </a><br>");
                RequestDispatcher requestDispatcher= req.getRequestDispatcher("LoginForm.html");
                requestDispatcher.include(req,resp);
            }
        }
        catch (ClassNotFoundException | SQLException | IOException |ServletException e){
            System.out.println(e.getMessage());
        }
    }

}
