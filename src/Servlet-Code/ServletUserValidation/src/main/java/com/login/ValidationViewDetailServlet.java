package com.login;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ValidationViewDetailServlet")
public class ValidationViewDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        ServletContext application2 = req.getServletContext();
        PrintWriter out =(PrintWriter) application2.getAttribute("out");
//        PrintWriter out = resp.getWriter();
        out.println("<center><table border = 2>" +
                "<tr><th> Username </th>" +
                "<th> Password </th>" +
                "</tr>");
        out.println("<tr> <td> "+application2.getAttribute("username")+"</td>" +
                "<td>"+application2.getAttribute("password")+"</td></tr>" +
                "</table></center>");

    }
}
