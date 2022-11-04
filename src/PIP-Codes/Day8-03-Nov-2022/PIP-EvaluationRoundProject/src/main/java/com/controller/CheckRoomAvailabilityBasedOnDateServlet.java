package com.controller;

import com.entities.Room;
import com.service.UserRoomBookingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/checkRoomAvailabilityBasedOnDateServlet")
public class CheckRoomAvailabilityBasedOnDateServlet extends HttpServlet {
    PrintWriter out ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        List<Room> roomList = new UserRoomBookingServiceImpl().checkRoomAvailability(req.getParameter("checkDate&Time"));
        if(roomList.size()> 0 ){
            for(Room room : roomList) {
                out.println("<h3>"+room.getRoomID() +"\t"+room.getRoomName()+" </h3><br>");
            }
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
        else{
            out.println("No Room Available !! ");
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
    }
}
