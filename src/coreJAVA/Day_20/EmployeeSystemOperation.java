package coreJAVA.Day_20;

import java.util.*;

import static coreJAVA.Day_20.EmployeeSystemDriver.count;

public class EmployeeSystemOperation  {
    static ArrayList<Employee> list = new ArrayList<>();
    int empID;
    String  name;
    String city;
    void addData(Scanner scanner){
        try {
            System.out.println("Enter your empID : ");
            empID = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter your name : ");
            name = scanner.nextLine();
            System.out.println("Enter your City : ");
            city = scanner.nextLine();
            list.add(new Employee(empID, name, city));
            System.out.println("Data " + (count + 1) + " Added successfully !!");
        }catch(Exception exception){
            System.out.println("Some thing went wrong !!");
            EmployeeSystemDriver.showMenu(scanner);
        }
    }
    void sortDataBasedOnID(){
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.empID-o2.empID;
            }
        });
        new EmployeeSystemOperation().viewData();
    }

    public void sortDataBasedOnName() {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        new EmployeeSystemOperation().viewData();
    }

    public void viewData( ){
        for(Employee item : list){
            System.out.println(item);
        }
    }

    public void sortDataBasedOnCity() {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.city.compareTo(o2.city);
            }
        });
        new EmployeeSystemOperation().viewData();
    }
}
