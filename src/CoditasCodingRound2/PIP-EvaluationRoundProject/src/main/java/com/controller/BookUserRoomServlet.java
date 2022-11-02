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
    int status;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        booking = new Booking();
        int userId = Integer.parseInt(req.getParameter("userId"));
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        booking.setStartDateTime(req.getParameter("startDate&Time"));
        booking.setEndDateTime(req.getParameter("endDate&Time"));
        status = new UserRoomBookingServiceImpl().addBooking(userId,roomId,booking);
        if(status == 1 ) {
            out.println("Room Booked for Conference Successfully !! ");
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
        else if(status ==0 ){
            out.println("SomeThing Went Wrong Either userID or roomID not found !!");
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }else{
            out.println("That room is already booked for that Slot !! " +
                    "<br > Try Again !!");
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
    }
}
