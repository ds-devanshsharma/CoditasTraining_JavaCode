import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/CSVtoExcel")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class CSVtoExcelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part=req.getPart("file");
        InputStream reader = part.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(
                "C:\\devansh-coditas\\CoditasTraining_JavaCode\\src\\Spring-Code\\CSVToExcelApplication\\src\\main\\webapp\\example.xls");
        int value=0;
        while((value=reader.read())!=-1){
            if ((char) value == ',')
                continue;
            outputStream.write(value);
        }

    }
}
