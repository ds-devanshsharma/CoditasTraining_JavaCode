package Stream.StreamTestApplication;

import Stream.Employee;

import java.util.ArrayList;
import java.util.List;

public class AddEmployee {
    public static List<Employee> employeeList =new ArrayList<>();
    static {
        employeeList.add(new Employee(11056 , "Devansh",45000,List.of("Project1","Project2")));
        employeeList.add(new Employee(11055 , "Manish",33500,List.of("Project0","Project2")));
        employeeList.add(new Employee(11050 , "Negi",67000,List.of("Project3","Project2")));
        employeeList.add(new Employee(11060 , "Baniya",37000,List.of("Project2","Project3")));
    }
}
