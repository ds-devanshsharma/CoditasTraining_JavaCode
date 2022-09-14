package com.login;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/success")
public class ValidationSuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application1 = getServletContext();
        //We need to typeCast to PrintWriter because getAttribute() return Object
        PrintWriter out=(PrintWriter) application1.getAttribute("out");
        resp.setContentType("text/html");
        out.println("<img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQP7NjSjKYoQFApBGgMXfrAioIDBfleCIZWyA&usqp=CAU' " +
                "style='height:20px;width:20px;margin-top:5px;'>"
                +"<span style ='font-size:20px'>"+application1.getAttribute("username")+"</span><br>" +
                "<span style ='font-size:15px'> <a href ='LoginForm.html'>Logout</a></span>" );
        // for Redirecting to next Page
                out.println("<p style='text-align:right;'>" +
                        "Click here to view Details : " +
                        "<a href='ValidationViewDetailServlet'>Click Here</a></p>");
        out.println("<h2><center > You Have Logged In SuccessFully !</center></h2><hr>");


    }
}
