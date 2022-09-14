import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out =  resp.getWriter();
        //printing data that we have got from Form
        out.println("<h2>Username :"+req.getParameter("name")+"" +
                "Password : "+req.getParameter("password")+"</h2>");

        // Using Cookies to maintain state
        Cookie[] cookies = req.getCookies();
        cookies[0].setValue(req.getParameter("name"));
        resp.addCookie(cookies[0]);
        cookies[1].setValue(req.getParameter("password"));
        resp.addCookie(cookies[1]);
        out.println("<a href = 'url'> click here to go url Rewriting</a> ");
    }
}
