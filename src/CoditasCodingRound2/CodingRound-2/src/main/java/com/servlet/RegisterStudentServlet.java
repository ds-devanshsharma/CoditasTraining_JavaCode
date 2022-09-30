package com.servlet;

import com.bean.Student;
import com.bean.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/registerStudent")
public class RegisterStudentServlet extends HttpServlet {
    Subject subject;
    Student student;
    PrintWriter out;
    List<Subject> listOfSubjects = new ArrayList<>();
    HashMap<String,Integer> subjectAndScoreMap = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        subject = new Subject();
        student = new Student();
        subject.setMaths(new HashMap<String, Integer>());

        //  setting student
        student.setStudentID(Integer.parseInt(req.getParameter("id")));
        student.setStudentName(req.getParameter("name"));



    }
}
