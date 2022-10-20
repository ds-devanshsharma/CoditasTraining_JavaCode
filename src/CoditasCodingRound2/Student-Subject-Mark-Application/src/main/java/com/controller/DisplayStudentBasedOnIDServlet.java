package com.controller;

import com.entities.Student;
import com.entities.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/displayServlet")
public class DisplayStudentBasedOnIDServlet extends HttpServlet {
    PrintWriter out;
    Student student;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        student =(Student) req.getSession().getAttribute("student");
        out.println("<h1>" +student.getStudentID() +"\n"
                +student.getStudentName()+ "\n"+
                " </h1>");
        for(Subject subject : student.getSubjectList()){
            out.println("<h4>"+subject.getSubjectID()+" "+subject.getSubjectName()+"</h4>");
        }
        out.println("<h5>Add more Subject ?? <a href ='AddSubject.html'> Yes </a> </h5>" +
                "<a href='logoutServlet' >LogOut</a>");
    }
}
