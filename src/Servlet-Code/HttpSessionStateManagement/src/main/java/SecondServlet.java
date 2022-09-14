import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        resp.setIntHeader("reload",1);
        if(session.isNew()){
            out.println("You are New user !!");
            req.getRequestDispatcher("Form.html").include(req,resp);
        }
        else{
            out.println("<h2>Username : "+session.getAttribute("username")+"</h2>" +
                    "<a href='logout'>logout</a>");

        }
    }
}
