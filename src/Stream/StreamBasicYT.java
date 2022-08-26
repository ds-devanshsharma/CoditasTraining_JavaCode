package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamBasicYT {
    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        employees.add(new Employee(11056,"Devansh Sharma",45000.0,List.of("Project1","Project2")));
        employees.add(new Employee(11057,"Shubham Negi",67500.0,List.of("Project1","Project2")));
        employees.add(new Employee(11056,"Manish Yadav",37000.0,List.of("Project1","Project2")));

        // printing employee
//        employees.stream()
//                .forEach(employee -> System.out.println(employee));
        // map
        employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getSalary()))
                .forEach(System.out::println);



    }
}
