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

@WebServlet("/checkRoomAvailabilityServlet")
public class CheckRoomAvailabilityServlet extends HttpServlet {
    PrintWriter out ;
    int status;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out =resp.getWriter();
        resp.setContentType("text/html");
        status = new UserRoomBookingServiceImpl()
                .checkRoomAvailabilityById(Integer.parseInt(req.getParameter("roomID")),
                        (req.getParameter("checkDate&Time")));
        if(status==1 ){
            out.println(Integer.parseInt(req.getParameter("roomID")+
                    "Room available !! "));
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
        else{
            out.println(req.getParameter("roomID")+"Room Not available !! ");
            req.getRequestDispatcher("Homepage.html").include(req,resp) ;
        }
    }
}
