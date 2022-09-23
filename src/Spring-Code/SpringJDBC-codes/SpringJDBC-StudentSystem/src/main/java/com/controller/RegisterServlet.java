package com.controller;

import com.DAO.StudentDAOImplementation;
import com.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    Student student;
    StudentDAOImplementation implementation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        //
        implementation = (StudentDAOImplementation) req.getSession().getAttribute("object");
        student =new Student();
        student.setId(Integer.parseInt(req.getParameter("id")));
        student.setName(req.getParameter("username"));
        student.setCity(req.getParameter("city"));
        student.setRating(Float.parseFloat(req.getParameter("rating")));
        student.setPassword(req.getParameter("password"));
        int check = implementation.insertStudent(student);

        if(check!=0) {
            out.println("<h3>" + req.getParameter("username") + " Registered Successfully !!</h3>");
            req.getRequestDispatcher("AdminPage.html").include(req, resp);
        }
        else{
            out.println("<h3>SomeThing Went Wrong !! </h3>");
            req.getRequestDispatcher("Register.html").include(req,resp);
        }
    }
}
