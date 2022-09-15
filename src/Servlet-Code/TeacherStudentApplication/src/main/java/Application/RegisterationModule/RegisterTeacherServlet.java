package Application.RegisterationModule;

import Application.JDBCConnection.JDBCConnectionImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

@WebServlet("/registerTeacher")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class RegisterTeacherServlet extends HttpServlet {
    private static final String UPLOAD_DIR ="Images";
    PreparedStatement preparedStatement;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try{
            // method to get profilePic path
            String profilePicPath=getprofilePath(req,resp);
            preparedStatement = JDBCConnectionImplementation.getJDBCConnection()
                    .prepareStatement("INSERT INTO TEACHER VALUES(?,?,?,?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(req.getParameter("id")));
            preparedStatement.setString(2,req.getParameter("username"));
            preparedStatement.setString(4,req.getParameter("about"));
            preparedStatement.setInt(3,Integer.parseInt(req.getParameter("exp")));
            preparedStatement.setString(5,profilePicPath);
            preparedStatement.setString(6,req.getParameter("password"));
            if(preparedStatement.executeUpdate()!=0){
                out.println("<h2>"+req.getParameter("username")+" registered Successfully !!</h2>");
                req.getRequestDispatcher("TeacherLogin.html").include(req,resp);
            }else{
                out.println("<h2>Something Went Wrong !! Try Again !!</h2>");
                req.getRequestDispatcher("RegisterTeacher.html").include(req,resp);
            }
        }catch (Exception e){
            out.println("<h3>SomeThing Wrong !!</h3>");
            System.out.println(e.getMessage());
        }
    }

    private String getprofilePath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("profilePic");//
        String fileName = extractFileName(part);//file name
        /**
         * *** Get The Absolute Path Of The Web Application ****
         */
        String applicationPath = getServletContext().getRealPath("");
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
//        System.out.println("applicationPath:" + applicationPath);
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        String savePath = uploadPath + File.separator + fileName;
//        System.out.println("savePath: " + savePath);
        String sRootPath = new File(savePath).getAbsolutePath();
//        System.out.println("sRootPath: " + sRootPath);
        part.write(savePath + File.separator);
        File fileSaveDir1 = new File(savePath);
        /*if you may have more than one files with same name then you can calculate some random characters
         and append that characters in fileName so that it will  make your each image name identical.*/
        String dbFileName = UPLOAD_DIR + File.separator + fileName;
        part.write(savePath + File.separator);
        //out.println(id+" "+firstName+" "+lastName+" "+fileName+" "+savePath);
        /*
         You need this loop if you submitted more than one file
         for (Part part : request.getParts()) {
         String fileName = extractFileName(part);
         part.write(savePath + File.separator + fileName);
         }*/
        return savePath;
    }

    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
