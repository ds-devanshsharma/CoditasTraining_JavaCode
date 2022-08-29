package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasicYT {
    static List<Employee> employees = new ArrayList<>();
    static{

        employees.add(new Employee(11056,"Devansh Sharma",45000.0,List.of("Project1","Project2")));
        employees.add(new Employee(11057,"Shubham Negi",67500.0,List.of("Project1","Project2")));
        employees.add(new Employee(11056,"Manish Yadav",37000.0,List.of("Project1","Project2")));
    }
    public static void main(String[] args) {

        // printing employee -forEach -Terminal-(consumer)
//        employees.stream()
//                .forEach(employee -> System.out.println(employee));
        // map -Intermeadiate Operator
        List<Employee> increasedSalList = employees.stream()
                .map(employee ->new Employee(
                      employee.getEmpID(),
                      employee.getName(),
                      employee.getSalary()*1.10,
                      employee.getProject()  ))
                .collect(Collectors.toList());




    }
}
