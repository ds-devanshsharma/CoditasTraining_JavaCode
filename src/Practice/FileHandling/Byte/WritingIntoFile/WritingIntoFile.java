package Practice.FileHandling.Byte.WritingIntoFile;

import java.io.*;

public class WritingIntoFile {
    public static void writeIntoFile(FileInputStream reader) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("C:\\devansh-coditas\\CoditasTraining_JavaCode\\" +
                "src\\Practice\\FileHandling\\WritingIntoFile\\Output.txt");
        int i;
        while((i=reader.read())!=-1){
            outputStream.write(i);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("<----- WRITING INTO FILE ----->");
        String path = "C:\\devansh-coditas\\CoditasTraining_JavaCode\\src\\Practice\\FileHandling\\Demo.txt";
        FileInputStream inputStream = new FileInputStream(path);
        writeIntoFile(inputStream);
    }
}
