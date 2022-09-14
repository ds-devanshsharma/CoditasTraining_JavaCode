package com.login;
// no need now Because We are using RequestDispatcher : include() in case of Request Failure
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/wrong")
public class ValidationWrongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application =getServletContext();
        /*here I am using PrintWriter Which I have created in ValidateServlet Class
          Where I have set it as ServletContext (setAttribute())
          here I am using that same PrintWriter Object (getAttributes())
         */
        PrintWriter out =(PrintWriter) application.getAttribute("out");
//        out.println("<h3>"+application.getAttribute("user")+"</h3>");
        out.println("<h2><center> Wrong Password !</center></h2><hr><br>" +
                "<a href='LoginForm.html'> Go back </a><br>");


    }
}
