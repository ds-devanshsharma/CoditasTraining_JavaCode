package Com.Example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ByeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ServletConfig config = getServletConfig();
        out.println("<h1><center>"+config.getInitParameter("ByeServletConfig")+"</center></h1><br><hr>");
//        ServletContext context = getServletConfig().getServletContext();



        out.println("\n<h2>BYE BYE !!!</h2>"+req.getParameter("username"));
    }
}
