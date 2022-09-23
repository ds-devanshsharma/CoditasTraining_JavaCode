package com.controller;

import com.DAO.StudentDAOImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private String admin ="admin";
    private String password="1111";
    public StudentDAOImplementation implementation;

    public void init() throws ServletException {
//        System.out.println("check1");
        ApplicationContext context  = new ClassPathXmlApplicationContext("Config.xml");
        implementation = (StudentDAOImplementation)context.getBean("Implementation");
//        System.out.println("check2");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     resp.setContentType("text/html");
     PrintWriter out = resp.getWriter();
     //
        req.getSession().setAttribute("object",implementation);

        if(req.getParameter("username").equals(admin)){
             if(req.getParameter("password").equals(password)){
                 resp.sendRedirect("AdminPage.html");
             }
             else{
                 out.println("<h2>Wrong Password !!</h2>");
                 req.getRequestDispatcher("index.jsp").include(req,resp);
             }
        }
        else{
            out.println("<h2>Wrong Username !!</h2>");
            req.getRequestDispatcher("index.jsp").include(req,resp);
        }
    }

}
