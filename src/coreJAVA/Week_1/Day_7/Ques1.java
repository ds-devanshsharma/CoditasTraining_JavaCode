package coreJAVA.Week_1.Day_7;

import java.util.Scanner;

/**
1. Create class WageEmployee extending Employee class with attributes as hrs (int)and
rate int and method computeSalary() to calculate the salary.
Print the salary and details of WageEmployee. (Note: Use the previous Employee classes.
Accept the values from the user. Default, Parameterised Constructor and toString() to be written
in all the classes)
 */
class Employee{
    int emp_id;
    String name;
    Employee(int emp_id,String name){
        this.emp_id=emp_id;
        this.name=name;
    }
    void detailsPrinter(){
        System.out.println("Employee empID : "+ emp_id + "\nEmployee Name : "+name);
    }
}
class WageEmployee extends Employee{
    int hrs;
    int rate;
    WageEmployee(int emp_id,String name) {
        super(emp_id,name);
        super.detailsPrinter();
    }
    public int computeSalary(int hrs,int rate){
        this.rate=rate;
        this.hrs=hrs;
        return hrs*rate;
    }
}
public class Ques1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your ID & name : ");
        int id = scanner.nextInt();
        String name = scanner.next();
        WageEmployee employee1 =new WageEmployee(id,name);

        System.out.println("Enter your Timing & rate : ");
        int hrs =scanner.nextInt();
        int rate=scanner.nextInt();
        System.out.println("Salary of Employee is : "+employee1.computeSalary(hrs,rate));
    }
}
