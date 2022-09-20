package Application.DisplayModule;
import Application.JDBCConnection.JDBCConnectionImplementation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/teacherDisplay")
public class TeacherDisplayServlet extends HttpServlet {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    PrintWriter out;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            out = resp.getWriter();
            //this is to restrict to go on back page
//            resp.setIntHeader("refresh",1);
            if(!req.getSession(true).isNew()) {
                out.println("<h3>" + req.getSession().getAttribute("username") + "</h3><br>");
                out.println("<a href='logoutServlet'>Logout</a><br>");
                //JDBC fetching
                resultSet = fetchTeacherData(req, resp);
                if(resultSet.next()) {
                    out.println("<div style='text-align:center'>" +
                            "profile:"
                           +"<img src='Images/"+resultSet.getString("PICPATH")+"'alt='Img Not found'>"+
                            "TeacherID : "+resultSet.getInt(1) +"</br>" +
                            "Experience :"+resultSet.getInt(3)+"<br>"+
                            "</div>");
                }
                else{
                    out.println("<h3>Record Not found !</h3>");
                    req.getRequestDispatcher("StudentLogin.html").include(req, resp);
                }
                resultSet = getStudentPic((int)req.getSession().getAttribute("id"));
                while(resultSet.next()){
                    out.println("<div style='align:center'>" +
                            "<img src='Images/"+resultSet.getString("PICPATH")+"' alt='Img not found'>"+
                            "</div>");
                }
            }else{
                System.out.println("<h4>You are new user !!</h4>");
                req.getRequestDispatcher("TeacherLogin.html").include(req,resp);
            }
        }catch (Exception e ){
            out.println("<h3>Something Went Wrong !!</h3>");
            resp.sendRedirect("TeacherLogin.html");
            System.out.println(e.getMessage());
        }

    }

    private ResultSet getStudentPic(int id) throws SQLException {
        try{
            preparedStatement = JDBCConnectionImplementation.getJDBCConnection()
                    .prepareStatement("SELECT PICPATH FROM STUDENT WHERE TEACHER_ID =?");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    private ResultSet fetchTeacherData(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            preparedStatement = JDBCConnectionImplementation.getJDBCConnection()
                    .prepareStatement("SELECT * FROM TEACHER WHERE TEACHER_ID = ? ");
//            System.out.println((int)req.getSession().getAttribute("id"));
            preparedStatement.setInt(1,(int)req.getSession().getAttribute("id"));
            resultSet = preparedStatement.executeQuery();

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
        return resultSet;
    }
}