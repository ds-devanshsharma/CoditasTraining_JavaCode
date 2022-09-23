package com.controller;

import com.DAO.StudentDAOImplementation;
import com.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/fetchServlet")
public class FetchServlet extends HttpServlet {
    List<Student> list;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        StudentDAOImplementation implementation = (StudentDAOImplementation)req.getSession()
                .getAttribute("object");
        list = implementation.fetchStudent();
        if(list.isEmpty()){
            out.println("<h3>Record Not Found !!</h3>");
            req.getRequestDispatcher("AdminPage.html").include(req,resp);
        }
        else{
            out.println("<center><h1> Student Records </h1><hr><br>" +
                    "<table>" +
                    "<tr> <td> ID :</td> <td> Name </td><td> City </td> <td> Rating</td> </tr> ");
            for(Student student : list){
                out.println("<tr> " +
                        "<td> "+student.getId()+" </td>" +
                        "<td> "+student.getName()+" </td>" +
                        "<td> "+student.getCity()+" </td>" +
                        "<td> "+student.getRating()+" </td>" +
                        "<td><a href ='deleteServlet?id="+student.getId()+"'><Button type='button'>Delete</a></td>" +
                        "</tr>");
            }
            out.println("</table></center>");
        }
    }
}
