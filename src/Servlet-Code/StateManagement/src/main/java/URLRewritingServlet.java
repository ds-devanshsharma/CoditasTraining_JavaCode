import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/url")
public class URLRewritingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out =  resp.getWriter();
        // getting data
        Cookie[] cookies = req.getCookies();
        String name = cookies[0].getValue();
        String password = cookies[1].getValue();
        //setting it again using URL rewriting
        out.println("<h2>Username :"+name+"" +
                "Password : "+password+"</h2>");
        out.println("<a href='hidden?name="+name+"&password="+password+"'>go to HiddenFormField</a>");

    }
}
