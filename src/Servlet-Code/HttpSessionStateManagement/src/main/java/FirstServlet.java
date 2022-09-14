import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out =resp.getWriter();
        //Using session here
        HttpSession session = req.getSession();
        session.setAttribute("username",req.getParameter("username"));
        session.setAttribute("password",req.getParameter("password"));
        out.println("<h1>"+req.getParameter("username")+"</h1><hr><br>" +
                "<a href='second'>nextPage</a>");
    }
}
