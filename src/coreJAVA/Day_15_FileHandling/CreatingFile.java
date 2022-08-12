package coreJAVA.Day_15_FileHandling;
/**
 * 1: creating a file file.txt at loaction :
 * C:\Users\coditas\Desktop\DevanshCode\FileHandling
  */

import java.io.File;
import java.io.IOException;
public class CreatingFile {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File1.txt");
       // creating second file
        File file2= new File("C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File2.txt");
        if(file1.createNewFile() && file2.createNewFile())
            System.out.println("File.txt created successfully !!");
        else
            System.out.println("File exist already !!");
    }
}
