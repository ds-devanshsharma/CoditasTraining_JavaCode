import JDBCConnection.ConnectionImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            preparedStatement = ConnectionImplementation.getJDBCConnection().
                    prepareStatement("SELECT * FROM USER WHERE NAME=? AND PASSWORD=?");
            preparedStatement.setString(1,req.getParameter("username"));
            preparedStatement.setString(2,req.getParameter("password"));
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                out.println("<h3><center>You have LoggedIN successfully!!<center><hr></h3><br>");
                HttpSession session = req.getSession();
                session.setAttribute("username",req.getParameter("username"));
                session.setAttribute("city",req.getParameter("city"));
                session.setAttribute("id",req.getParameter("id"));
                resp.sendRedirect("userDisplay");
            }
            else{
                out.print("SomeThing Went Wrong");
                req.getRequestDispatcher("AdminForm.html").include(req,resp);
            }
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
}
