package coreJAVA.Day_15_FileHandling;

import java.io.*;

// Merging two files(File1.txt && File2.txt) data into single file
public class MergingFile {
    public static void main(String[] args) throws IOException {
        FileOutputStream file3 = new FileOutputStream(
                "C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File3.txt",true);
        DataOutputStream file33 = new DataOutputStream(file3);
        FileInputStream reader1 = new FileInputStream("C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File1.txt");
        FileInputStream reader2 = new FileInputStream("C:\\Users\\coditas\\Desktop\\DevanshCode\\FileHandling\\File2.txt");
        DataInputStream reader3 = new DataInputStream(reader1);
        DataInputStream reader4 = new DataInputStream(reader2);
        SequenceInputStream sequenceInputStream = new SequenceInputStream(reader3,reader4);
//        while(sequenceInputStream.read()!=-1){
//            System.out.print((char)sequenceInputStream.read());
//        } printing on Console
//        int contentInByte ;
//        //reading from sequence and writing into File3.txt
//        while((contentInByte=sequenceInputStream.read())!=-1){
//            file3.write((char)contentInByte);
//        }

//        while(sequenceInputStream.read()!=-1){
//            file3.write((char)sequenceInputStream.read());
//        }
        do {
            int i=sequenceInputStream.read();
            if(i==-1)
                System.exit(0);
            file33.writeChar(i);

        }while(true);
//        file3.close();
//        reader1.close();
//        reader2.close();
//        sequenceInputStream.close();
    }
}
