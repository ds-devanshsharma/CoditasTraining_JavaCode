package com.controller;

import com.entities.Student;
import com.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowStudentList")
public class ShowStudentListServlet extends HttpServlet {
    PrintWriter out ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = new StudentServiceImpl().showStudentList();
        resp.setContentType("text/html");
        out = resp.getWriter();
        out.println("<center><h1>" +
                "Student-Records" +
                "</h1><hr><br>");
        for(Student student : studentList){
            out.println("<label>"+
                    student.getStudentID() +"        "+ student.getStudentName()+"        "
                    +"<a href='deleteStudent?id="+student.getStudentID()+"'>delete</a>" +
                    "        " +
                    "<a href='loginServlet?id="+student.getStudentID()+"'>login</a>"
                    +"<label><br>");
        }
        out.println("</center>");
    }
}
