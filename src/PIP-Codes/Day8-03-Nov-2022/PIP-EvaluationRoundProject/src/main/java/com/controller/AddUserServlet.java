package com.controller;

import com.entities.User;
import com.service.UserRoomBookingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    User user;
    PrintWriter out;
    boolean status ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       out = resp.getWriter();
       user = new User();
       user.setUserName(req.getParameter("username"));
        status = new UserRoomBookingServiceImpl().addUser(user);
        if(status){
            out.println("User Added Successfully !");
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
        else{
            out.println("SomeThing Went Wrong !!");
            req.getRequestDispatcher("AddUser.html").include(req,resp);
        }
    }
}
