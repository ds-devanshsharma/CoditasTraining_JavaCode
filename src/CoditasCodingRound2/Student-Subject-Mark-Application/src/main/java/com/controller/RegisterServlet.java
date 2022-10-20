package com.controller;

import com.HibernateUtil.SessionFactoryProvider;
import com.entities.Student;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    StudentService service;
    PrintWriter out;
    @Override
    public void init() throws ServletException {
        service = new StudentServiceImpl();
        SessionFactory sessionFactory = SessionFactoryProvider.sessionFactoryProviderMethod();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        HttpSession session = req.getSession();
        session.setAttribute("name",req.getParameter("name"));
        Student student = new Student();
        student.setStudentName(req.getParameter("name"));

        String status = service.registerStudent(student);
        if (status.equalsIgnoreCase("Registered")) {
            out.println("<h1>" +student.getStudentName()+
                    " Registered Successfully !</h1>");
            req.getRequestDispatcher("Login.html").include(req,resp);
        }else{
            req.getRequestDispatcher("RegisterStudent.html").include(req,resp);
        }
    }
}
