import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/CSVtoExcel")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class CSVtoExcelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Part part=req.getPart("file");
        String filename = part.getSubmittedFileName();

        if(!checkIsCSV(filename)){
            out.println("<h2>This is not CSV file ! please upload CSV file !!</h2>");
            req.getRequestDispatcher("CSVtoExcelPage.html").include(req,resp);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream()));
        FileWriter writer = new FileWriter("C:\\devansh-coditas\\CoditasTraining_JavaCode\\src\\" +
                "Spring-Code\\CSVToExcelApplication\\src\\main\\CSVtoExcelFile\\Excel.xlsx");
        int value=0;
        while((value=reader.read())!=-1){
            if ((char) value == ';')
                continue;
            writer.write(value);
        }
        out.println("<marquee><h3>file has been converted successfully !!</h3></marquee>");
    }
    static boolean checkIsCSV(String filename){
        if(filename.charAt(filename.length()-1)=='v')return true;
        return false;
    }
}
