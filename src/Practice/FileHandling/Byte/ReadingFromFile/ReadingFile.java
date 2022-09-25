package Practice.FileHandling.Byte.ReadingFromFile;

import java.io.*;

public class ReadingFile {
    public static void readFile(FileInputStream reader) throws IOException {
        int i=0;
        while((i=reader.read())!=-1){
            System.out.print((char)i);

        }
    }
    public static void readFile(BufferedInputStream reader) throws IOException {
        int i=0;
        while((i=reader.read())!=-1){
            System.out.print((char)i);

        }
    }
    public static void readFile(DataInputStream reader) throws IOException {
        String i;
        while(reader.readLine()!=null){
            System.out.print(reader.readLine());
        }
    }
    public static void readFile(SequenceInputStream
                                        reader) throws IOException {
        int i=0;
        while((i=reader.read())!=-1){
            System.out.print((char)i);

        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Reading from File : Demo.txt ");
        String path2="C:\\devansh-coditas\\CoditasTraining_JavaCode\\src\\Practice\\FileHandling\\Demo2.txt";
        String path="C:\\devansh-coditas\\CoditasTraining_JavaCode\\src\\Practice\\FileHandling\\Demo.txt";
//        FileInputStream inputStream = new FileInputStream(path);
//        readFile(inputStream);
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
//        readFile(bufferedInputStream);
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(path));
        readFile(dataInputStream);
//        SequenceInputStream sequenceInputStream = new SequenceInputStream(
//                new FileInputStream(path),
//                new FileInputStream(path2)
//        );
//        readFile(sequenceInputStream);
    }


}
