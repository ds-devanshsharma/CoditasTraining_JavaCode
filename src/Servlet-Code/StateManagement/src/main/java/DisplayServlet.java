import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        // fetching details here

        out.println("<h1><center>"+req.getParameter("name")+" </center></h1><br>");
        out.println("<h1><center>"+req.getParameter("password")+" </center></h1>");
        out.println("<a href= 'sendRedirect' target='_blank'> ClickHere</a>");

    }
}
