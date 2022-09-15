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
@WebServlet("/userDisplay")
public class UserDisplayServlet extends HttpServlet {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session=req.getSession();

        if(!session.isNew()){
        try {
            preparedStatement = ConnectionImplementation.getJDBCConnection()
                    .prepareStatement("SELECT * FROM USER ");
            resultSet = preparedStatement.executeQuery();
            out.println("<center><div  style='border:2px solid black; height: 400px; width:50%' >" +
                    "<h1>User Data</h1><hr><br>" +
                    "<table border='1' > " +
                    "<tr><th>ID </th><th>UserName</th><th>City</th></tr>");
            while(resultSet.next()){
                out.println("<tr><td>"+resultSet.getInt(1)+"</td>"+
                        "<td>" +resultSet.getString(2)+"</td>"+
                        "<td>"+resultSet.getString(3)+"</td></tr>");
            }
            out.print("</table>");
            out.println("<form action ='RegisterForm.html'>" +
                        "<Button type= 'submit'>Register</Button></form>&nbsp;");
            out.println("<a href='DeleteForm.html'><button type='button'>Delete</button></a>&nbsp;");
            out.println("<a href='logout'><button type='button'>logout</button></a></div></center>");

        }catch(Exception e ){

        }
        }
        else {
            out.println("New User");
        }
    }
}
