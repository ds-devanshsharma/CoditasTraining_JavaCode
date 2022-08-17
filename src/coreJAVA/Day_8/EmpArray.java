package coreJAVA.Day_8;

import java.util.Scanner;

class Employee{
   private int id;
   private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    public Employee(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

//    @Override
//    public String toString() {
//        return  "id = " + id +"\t"+
//                " name= " + name + "\n";
//    }
}
public class EmpArray {

    public static void main(String[] args) {
        int id ;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many Records you want to store : ");
        int records = scanner.nextInt();

        // creating array of type Employee;
        Employee[] empArray = new Employee[records];
        Employee e =null;

        for( int i=0 ;i<records;i++) {
            e=new Employee();
            System.out.println("Enter your id : ");
            e.setId(scanner.nextInt());
            empArray[i]=e;

        }
    }

}
