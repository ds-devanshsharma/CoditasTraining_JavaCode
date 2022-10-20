package com.controller;

import com.entities.Booking;
import com.service.UserRoomBookingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bookUserRoomServlet")
public class BookUserRoomServlet extends HttpServlet {
    Booking booking ;
    PrintWriter out ;
    boolean status;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();

        status = new UserRoomBookingServiceImpl().addBooking(
                Integer.parseInt(req.getParameter("userId")),
                Integer.parseInt(req.getParameter("roomId")),
                req.getParameter("dateTime")
        );
        if(status){
            out.println("Room Booked for Conference Successfully !! ");
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
        else{
            out.println("SomeThing Went Wrong Either userID or roomID not found !!");
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
    }
}
