package Practice;

import java.io.*;

public class CSVDemo {
    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(
                    "C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\ExcelFile.xls"));

        BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\Data.csv"));
        String currentReader ="";
        while((currentReader=reader.readLine()) != null) {
            //System.out.println(reader.readLine());
            writer.write(currentReader);
            writer.newLine();
        }
    }
}
