package coreJAVA.Day_17;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RandomAccessDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\coditas\\Desktop\\" +
                "DevanshCode\\FileHandling\\File4.txt","rw");
        raf.writeBytes("Firstline");
       // raf.seek(5);

        raf.seek(5);
        raf.writeBytes("Second");
        raf.seek(0);
        //getFilePointer() returns pointers location
        System.out.println("current offset in this file : "+raf.getFilePointer());
        System.out.println("Content added successfully !! "+ raf.readLine());
    }
}
/*
current offset in this file : 0
Content added successfully !! FirstSecond

 */