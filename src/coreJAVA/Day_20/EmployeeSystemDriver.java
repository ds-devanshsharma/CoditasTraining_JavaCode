package coreJAVA.Day_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSystemDriver {
    static int count ;
    public static  void showMenu(Scanner scanner){
        System.out.println("Enter 1 for insert DATA :");
        System.out.println("Enter 2 to view sorted data based on empID  :");
        System.out.println("Enter 3 to view sorted data based on Name  :");
        System.out.println("Enter 4 to view sorted data based on City  :");
        System.out.println("Enter 5 to view Data   :");
        System.out.println("Enter 0 for Exit !!");
        int choice = scanner.nextInt();
        switch(choice){
            case 1 :
                new EmployeeSystemOperation().addData(scanner);
                count++;
                break;
            case 2 :
                new EmployeeSystemOperation().sortDataBasedOnID();
                break;
            case 3 :
                new EmployeeSystemOperation().sortDataBasedOnName();
                break;
            case 4 :
                new EmployeeSystemOperation().sortDataBasedOnCity();
                break;
            case 5 :
                new EmployeeSystemOperation().viewData();
                break;
            case 0 :
                System.out.println("You have logged out Successfully !!");
                System.exit(0);

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Employee System !!");
        while(true){
            showMenu(scanner);
        }
    }
}
