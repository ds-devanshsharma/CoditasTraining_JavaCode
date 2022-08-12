package coreJAVA.Day_16_UserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques2BR {
    public static void inputDetails(Employee employee) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter ID : ");
        employee.id = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter Name :");
        employee.name = bufferedReader.readLine();
        System.out.println("Enter salaray :");
        employee.salary =Float.parseFloat(bufferedReader.readLine());
    }
    public static void printDetails(Employee employee){
        System.out.println("This is from BufferReader !");
        System.out.println(employee);
    }
}
