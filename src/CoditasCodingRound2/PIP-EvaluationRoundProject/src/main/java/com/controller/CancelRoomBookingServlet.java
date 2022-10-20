package com.controller;

import com.service.UserRoomBookingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cancelRoomBookingServlet")
public class CancelRoomBookingServlet extends HttpServlet {
    PrintWriter out;
    boolean status;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        status= new UserRoomBookingServiceImpl()
                .cancelBooking(Integer.parseInt(req.getParameter("roomId")));
        if(status){
            out.println("Room-Booking-cancelled Successfully !!");
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
        else{
            out.println("That room not exist !!");
            req.getRequestDispatcher("CancelBooking.html").include(req,resp);
        }
    }
}
