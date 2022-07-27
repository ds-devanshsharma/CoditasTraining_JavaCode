package coreJAVA.Week_1.Day_7;

import java.util.Arrays;
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

    @Override
    public String toString() {
        return "Employee " +
                "emp_id : " + emp_id +
                ", name :" + name ;
    }
}

/**
  3. Create Manager class extending Employee class with attributes as fixed salary(int) and
  incentives(int) and method compute Salary() to calculate the salary of Manager .Print the salary
  and details of Manager
 */
class Manager extends Employee{
    int fixedSalary;
    int incentives;
    Manager(int emp_id, String name,int fixedSalary,int incentives) {
        super(emp_id, name);
        this.fixedSalary = fixedSalary;
        this.incentives = incentives;
    }
    public int computeSalary(){

        return fixedSalary+incentives ;
    }
}
class WageEmployee extends Employee{
    int hrs;
    int rate;
    WageEmployee(int emp_id,String name,int hrs,int rate) {
        super(emp_id,name);
        this.rate=rate;
        this.hrs=hrs;
        super.detailsPrinter();

    }
    public int computeSalary(){

        return hrs*rate;
    }
}

/**
  2. Create SalesPerson class extending WageEmployee with attributes as sales(int) and
  commission (int).
  Override the Compute Salary() in Salesperson class and print the salary and details of
  SalesPerson
 */
class SalesPerson extends WageEmployee{
    int sales;
    int commission;
    SalesPerson(int sales, int commission,int hrs,int rate,int emp_id,String name) {
        super(emp_id,name,hrs,rate);
        this.commission=commission;
        this.sales=sales;

    }
    public int computeSalary(){

        return (hrs*rate)+commission ;
    }
}

public class Ques1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your ID & name : ");
//        int id = scanner.nextInt();
//        String name = scanner.next();
//        System.out.println("Enter your Timing & rate : ");
//        int hrs =scanner.nextInt();
//        int rate=scanner.nextInt();
//        System.out.println("Enter your sales count & Commisson :  ");
//        int sales=scanner.nextInt();
//        int commisson=scanner.nextInt();
//        SalesPerson employee1 =new SalesPerson(sales,commisson,hrs,rate,id,name);

        /*
        Enter your ID & name :
        11056
        Devansh
        Enter your Timing & rate :
        8
        1500
        Enter your sales count & Commisson :
        8
        1500
        Employee empID : 11056
        Employee Name : Devansh
        Salary of Employee is : 13500
         */
//        System.out.println("HI manager!! Please Enter your fixedSalary & incentives : ");
//        int fixedSalary = scanner.nextInt();
//        int incentives = scanner.nextInt();
//        Manager manager = new Manager(id,name,fixedSalary,incentives);
//        System.out.println("Gross Salary of Employee is : "+manager.computeSalary());
        /*
        Enter your ID & name :
        11056
        Devansh
        HI manager!! Please Enter your fixedSalary & incentives :
        45000
        250
        Gross Salary of Employee is : 45250
         */
        /**
         4. Write a TestEmployee class to print the details of all types of employees (use array[] of
         Employee class)
         */
        Employee[] emp =new Employee[4];
        emp[0]=new Employee(101,"Devansh");
        emp[1]=new Employee(102,"Negi");
        emp[2]=new Employee(103,"Baniya");
        emp[3]=new Employee(104,"Manish");

        //System.out.println(emp);

        System.out.println(Arrays.toString(emp));
    }
}
