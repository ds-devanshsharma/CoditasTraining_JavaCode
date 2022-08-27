package Stream.StreamTestApplication;

import java.util.Scanner;

import static Stream.StreamTestApplication.AddEmployee.employeeList;

public class EmployeeSystemStream {

    public static void main(String[] args) {
        System.out.println("<- Welcome to Employee System -> ");
//        System.out.println("Enter 1 for add Employee Record : \n" +
//                "Enter 2 for Viewing Employee Record :\n" +
//                "Enter 3 for Viewing Employee Record in salaryWise sorted Order :\n" +
//                "Enter 4 for Viewing Employee Record in  NameWise  sorted Order : \n" +
//                "Enter 5 for Deleting a Record : \n" +
//                "Enter 0 for LogOut : ");
//        Scanner scanner = new Scanner(System.in);
//        int choice =scanner.nextInt();
//        switch (choice){
//            case 1 :
//
//        }

        //adding employee to list
        new AddEmployee();
        // sorting based on salary
        System.out.println("Employee list sorted on Salary : ");
        new SortEmployee().sortBySalary(employeeList);
        System.out.println("*****************************************************************************");
        System.out.println("Employee list sorted on name : ");
        new SortEmployee().sortByName(employeeList);
        System.err.println("*****************************************************************************");

    }
}
