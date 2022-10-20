package com.controller;

import com.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/addSubjectServlet")
public class AddSubjectToStudentServlet extends HttpServlet {
    PrintWriter out ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean status = new StudentServiceImpl()
                .updateStudent(Integer.parseInt(req.getParameter("studentId")),req);
        resp.setContentType("text/html");
        out = resp.getWriter();
        if(status){
            out.println("<h1> Subject Added Successfully !! \n" +
                    "Login to view Student Details !! </h1>");
            req.getRequestDispatcher("Login.html").include(req,resp);
        }
        else{
            out.println("<h1>Student Not Found !!</h1>");
            req.getRequestDispatcher("AddSubject.html").include(req,resp);
        }
    }
}
