package com.controller;

import com.entities.Student;
import com.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class StudentLoginServlet extends HttpServlet {
    PrintWriter out;
    Student student;
    HttpSession httpSession ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        student = new StudentServiceImpl().showStudentBasedOnID(Integer.parseInt(req.getParameter("id")));
        if( student !=null){
            httpSession = req.getSession();
            httpSession.setAttribute("student",student);
            req.getRequestDispatcher("displayServlet").forward(req,resp);
        }
        else{
            out.println("<h1 > " +
                    "Record Not Found !! " +
                    "</h1>");
            req.getRequestDispatcher("Login.html").include(req,resp);
        }
    }
}
