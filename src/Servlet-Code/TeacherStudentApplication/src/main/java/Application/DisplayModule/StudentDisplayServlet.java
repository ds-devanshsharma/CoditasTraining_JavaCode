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

@WebServlet("/studentDisplay")
public class StudentDisplayServlet extends HttpServlet {
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
                resultSet = fetchData(req, resp);
                if (resultSet.next()) {
                    String studentPath= "Images/"+resultSet.getString(5);
                    out.println("" +
                            "<div style='text-align:left'>\n"
                            + " <br>Profile : <br> "
                            + "<img src='"+studentPath+"' width='200' height='200' alt='Img not Found !' >"
                            + "<br>StudentID : " + resultSet.getInt(1)
                            + "<br>Username : " + resultSet.getString(2)
                            + "<br>About me :" + resultSet.getString(3));

                    String teacherPicPath="Images/"+ getTeacherPic(resultSet.getInt(4));
                    out.println("</div>" +
                            "<div style='text-align:right'>" +
                            "Your Teacher :<br>" +
                            "<img src='"+teacherPicPath+"' width='200' height='200' alt='Img not Found !' >"+
                            "</div>");
                } else {
                    out.println("<h3>Record Not found !</h3>");
                    req.getRequestDispatcher("StudentLogin.html").include(req, resp);
                }
            }else{
                System.out.println("<h4>You are new user !!</h4>");
                req.getRequestDispatcher("StudentLogin.html").include(req,resp);
            }
        }catch (Exception e ){
            out.println("<h3>Something Went Wrong !!</h3>");
            resp.sendRedirect("StudentLogin.html");
            System.out.println(e.getMessage());
        }

    }

    private String  getTeacherPic(int id) throws SQLException {
        try{
            preparedStatement = JDBCConnectionImplementation.getJDBCConnection()
                    .prepareStatement("SELECT PICPATH FROM TEACHER WHERE TEACHER_ID =?");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        resultSet.next();
        return resultSet.getString("PICPATH");
    }

    private ResultSet fetchData(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            preparedStatement = JDBCConnectionImplementation.getJDBCConnection()
                    .prepareStatement("SELECT * FROM STUDENT WHERE STUDENT_ID = ? ");
//            System.out.println((int)req.getSession().getAttribute("id"));
            preparedStatement.setInt(1,(int)req.getSession().getAttribute("id"));

            resultSet = preparedStatement.executeQuery();

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
        return resultSet;
    }
}