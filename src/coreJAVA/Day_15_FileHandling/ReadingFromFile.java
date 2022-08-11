package coreJAVA.Day_15_FileHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Reading from a file and printing it on console
 */
public class ReadingFromFile {
    public static void onConsolePrinter( Scanner scanner){
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File.txt");
            Scanner scanner = new Scanner(file);
            onConsolePrinter(scanner);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
 *  Hi i am Devansh Sharma
    I am from Kanpur

 */
