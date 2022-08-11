package coreJAVA.Day_15_FileHandling;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Finding details of file : C:\Users\coditas\Desktop\DevanshCode\FileHandling\File.txt
 */
public class FileDetails {
    public static void main(String[] args) {

            File file = new File("C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File.txt");

        if(file.exists()){
            // this exist() return true if file exist otherwise false
            System.out.println("Length/size in bytes of file :: "+file.length());
            // getName() will give you name of the file
            System.out.println("Name of the of File :: "+file.getName());
            // getAbsoluteFile() return total path of file
            System.out.println("Absolute Totalpath file :: "+file.getAbsoluteFile());
            // canRead() | canWrite() | canExecute() return true/false value
            System.out.println("Can we read this file ?? "+file.canRead());
            System.out.println("Can we write this file ?? "+file.canWrite());
            System.out.println("Can we execute this file ?? "+file.canExecute());
        }
    }
}
/*
Length of file :: 0
Name of the of File :: File.txt
Absolute Totalpath file :: C:\Users\coditas\Desktop\DevanshCode\FileHandling\File.txt
Can we read this file ?? true
Can we write this file ?? true
Can we execute this file ?? true
 */
