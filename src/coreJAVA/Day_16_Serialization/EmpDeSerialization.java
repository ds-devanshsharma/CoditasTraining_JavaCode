package coreJAVA.Day_16_Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EmpDeSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("C:\\Users\\coditas\\Desktop\\DevanshCode\\SerializationDemo\\Employee.txt"));
        Employee employee = (Employee) objectInputStream.readObject();
        System.out.println("Employee DATA "+ employee.toString());
    }
}
