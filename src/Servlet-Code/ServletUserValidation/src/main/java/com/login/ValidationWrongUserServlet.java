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
@WebServlet("/wrongUserName")
public class ValidationWrongUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = getServletContext();
        PrintWriter out =(PrintWriter) application.getAttribute("out");
        out.println("<h2><center> Wrong UserName !!</center><h2><hr><br>" +
                "<a href='LoginForm.html'>Go Back</a>");
        application.setAttribute((String)application.getAttribute("user"),"");
    }
}
