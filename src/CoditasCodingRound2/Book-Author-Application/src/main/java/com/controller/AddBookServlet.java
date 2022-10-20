package com.controller;

import com.entities.Book;
import com.hibernateUtil.SessionFactoryProvider;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = SessionFactoryProvider.sessionFactoryProviderMethod();
    }

    PrintWriter out;
    Book book ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        book = new Book();


    }
}
