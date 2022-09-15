import JDBCConnection.ConnectionImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    PreparedStatement preparedStatement;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            preparedStatement = ConnectionImplementation.getJDBCConnection()
                    .prepareStatement("DELETE FROM USER WHERE ID = ?");
            preparedStatement.setInt(1,Integer.parseInt(req.getParameter("deleteID")));
            if(preparedStatement.executeUpdate()!=0){
                out.print("Record Deleted Successfully ");
                req.getRequestDispatcher("userDisplay").include(req,resp);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
