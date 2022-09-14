package Com.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html");
         PrintWriter out = resp.getWriter();
         String username=req.getParameter("username");
         String password=req.getParameter("password");
         String gender=req.getParameter("gender");
         String email=req.getParameter("email");
         String course=req.getParameter("course");
         String checkBox = req.getParameter("checkbox");
         if(!checkBox.equals("checked")){
             out.println("<h2>you have not accepted terms & conditions</h2>");
             req.getRequestDispatcher("Registration.html").include(req,resp);
         }else{
             out.println("<h2>Welcome To RegisterServlet<br></h2>");
             out.println("<h2> Username : "+username+"<br>" +
                     "Course : "+course+"</h2>");
         }
    }
}
