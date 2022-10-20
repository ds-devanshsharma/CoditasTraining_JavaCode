package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logoutServlet")
public class StudentLogoutServlet extends HttpServlet {
    PrintWriter out;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        req.getSession().invalidate();
        out.println("You have been logged out successfully !!");
        req.getRequestDispatcher("Homepage.html").include(req,resp);
    }
}
