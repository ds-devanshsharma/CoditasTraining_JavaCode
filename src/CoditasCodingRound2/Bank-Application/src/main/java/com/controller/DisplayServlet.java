package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/displayServlet")
public class DisplayServlet extends HttpServlet {
    PrintWriter out ;
    HttpSession httpSession;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();

        out.println("<center> " +
                "<h1>!! WELCOME TO LAXMI CHIT_FUND !!</h1><hr><br>"
                +httpSession.getAttribute("user")+
                "</center>");
    }
}
