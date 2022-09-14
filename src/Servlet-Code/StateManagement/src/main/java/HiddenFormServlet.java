import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/hidden")
public class HiddenFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out =  resp.getWriter();
        out.println("<h2>Username :"+req.getParameter("name")+"" +
                "Password : "+req.getParameter("password")+"</h2>");
        out.println("<form action='session'>" +
                "<input type ='hidden' name='name' value='"+req.getParameter("name")+"'>" +
                "<input type= 'hidden' name='password' value='"+req.getParameter("password")+"'>" +
                "<input type= 'submit' value='Click Here to send data to session'>");
    }
}
