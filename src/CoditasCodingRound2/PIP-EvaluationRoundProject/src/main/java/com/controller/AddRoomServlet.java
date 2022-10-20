package com.controller;

import com.entities.Room;
import com.service.UserRoomBookingService;
import com.service.UserRoomBookingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addRoomServlet")
public class AddRoomServlet extends HttpServlet {
    Room room ;
    PrintWriter out ;
    boolean status;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        room = new Room();
        room.setRoomName(req.getParameter("roomName"));
        status = new UserRoomBookingServiceImpl().addRoom(room);
        if(status){
            out.println("Room Added Successfully !");
            req.getRequestDispatcher("Homepage.html").include(req,resp);
        }
        else{
            out.println("SomeThing Went Wrong !!");
            req.getRequestDispatcher("AddRoom.html").include(req,resp);
        }
    }
}
