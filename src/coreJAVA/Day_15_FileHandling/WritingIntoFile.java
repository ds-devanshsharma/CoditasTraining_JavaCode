package coreJAVA.Day_15_FileHandling;

import java.io.*;

// Writing into file using FileWriter
public class WritingIntoFile {
    public static void main(String[] args) throws FileNotFoundException {

          PrintWriter printWriter1 = new PrintWriter("C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File1.txt");
          PrintWriter printWriter2 = new PrintWriter("C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File2.txt");
          printWriter1.write("This is from first file !!\n");
          printWriter2.write("This is from Second file !!");
          printWriter1.close();
          printWriter2.close();

        System.out.println("Content added successfully !!");
    }
}
