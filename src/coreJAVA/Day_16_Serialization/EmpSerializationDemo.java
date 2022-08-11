package coreJAVA.Day_16_Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EmpSerializationDemo {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee(121,"Devansh",45000f);

        FileOutputStream file = new FileOutputStream("C:\\Users\\coditas\\Desktop\\DevanshCode\\SerializationDemo\\Employee.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);

        objectOutputStream.writeObject(employee);
        System.out.println("Added succesfully !!");
    }
}
