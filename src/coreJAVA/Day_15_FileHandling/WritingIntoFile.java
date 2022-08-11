package coreJAVA.Day_15_FileHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// Writing into file using FileWriter
public class WritingIntoFile {
    public static void main(String[] args) {
        try {
            Writer fWriter = new FileWriter("C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File.txt");
            fWriter.write("Hi i am Devansh Sharma \nI am from Kanpur");
            System.out.println("Content added succesfully !!");
            fWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
