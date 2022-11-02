package com.controller;

import com.entities.Booking;
import com.service.UserRoomBookingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dateRangeBookingDetailsServlet")
public class DateRangeBookingDetailServlet extends HttpServlet {
        PrintWriter out ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out = resp.getWriter();
        resp.setContentType("text/html");
        String startDate = req.getParameter("startDateTime");
        String lastDate = req.getParameter("lastDateTime");
        List<Booking> bookingList = new UserRoomBookingServiceImpl().bookingDetail(startDate ,lastDate);
        for(Booking booking : bookingList){
            out.println("<h3>"+booking +"</h3><br>");
        }
        req.getRequestDispatcher("Homepage.html").include(req,resp);
    }
}
