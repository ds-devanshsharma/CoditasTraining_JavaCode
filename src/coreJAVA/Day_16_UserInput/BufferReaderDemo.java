package coreJAVA.Day_16_UserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Data{
    int id;
    float marks;
    String name;
    char grade;
     public void inputDetails() throws IOException {
        //Class obj = new class(Charactor input so Reader =>new InputStreamReader(console=>System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Name : ");
         name = bufferedReader.readLine();
        System.out.println("Enter id : ");
         id = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter marks : ");
        marks = Float.parseFloat(bufferedReader.readLine());
        System.out.println("Enter grade : ");
        //this is for reading single charactor
        grade =(char) bufferedReader.read();

    }
     public void printDetails(){
        System.out.println("Name : "+name +"\nId : "+id+"\nMarks : "+marks+"\nGrade : "+grade);
    }
}
public class BufferReaderDemo {
    public static void main(String[] args) throws IOException {
        Data data = new Data();
        data.inputDetails();
        data.printDetails();
    }
}
/*
Enter Name :
Devansh Sharma
Enter id :
11057
Enter marks :
87
Enter grade :
B
Name : Devansh Sharma
Id : 11057
Marks : 87.0
Grade : B

 */