package coreJAVA.Week_1.Day_8;

import java.util.Arrays;
import java.util.Scanner;

class Employee{
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return  "id = " + id +"\t"+
                " name= " + name + "\n";
    }
}
public class EmpArray {

    public static void main(String[] args) {
        String name;
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many Records you want to store : ");
        int records = scanner.nextInt();

        // creating array of type Employee;
        Employee[] empArray = new Employee[records];

        for( id=0 ;id<records;id++){
            System.out.println("Enter your name : ");
             name = scanner.next();
            empArray[id] = new Employee(id,name);
        }
        System.out.println(Arrays.toString(empArray));
    }

}
