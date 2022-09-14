package com.calculator;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdditionServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
        //setting contentType

        //getting reading writer
        PrintWriter writer = res.getWriter();
        res.setContentType("text/html");
        //taking data from HomePage
        writer.println("\n<h3> Sum of number 1 & number 2 : </h3>"
                +(Integer.parseInt(req.getParameter("number1"))+Integer.parseInt(req.getParameter("number2"))));
        writer.println("<a href ='HomePage.html' >back</a>");
    }
}
