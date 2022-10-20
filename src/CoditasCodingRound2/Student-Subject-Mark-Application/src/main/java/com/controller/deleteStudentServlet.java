package com.controller;

import com.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteStudent")
public class deleteStudentServlet extends HttpServlet {
    PrintWriter out ;
    boolean status;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        status = new StudentServiceImpl().deleteStudent(Integer.parseInt(req.getParameter("id")));
        if(status){
            out.println("<h2>Record Deleted Successfully !!</h2>");
            req.getRequestDispatcher("ShowStudentList").include(req,resp);
        }
        else{
            out.println("<h2>SomeThing Went Wrong </h2>");
            req.getRequestDispatcher("ShowStudentList").include(req,resp);
        }
    }
}
