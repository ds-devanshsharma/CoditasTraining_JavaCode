package Stream.StreamPractice;

import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<Employee> list = Employee.empDefaultList();
        System.out.println("Before Updation :");
        System.out.println(list);
        //updatin salary based on ID =11056 by 10k
        //peek() along with findFirst()
        list.stream()
                .filter(employee -> employee.getEmpID()==11056)
                .peek(employee -> employee.setSalary(employee.getSalary()+10000))
                        .findFirst();
        System.out.println("After Updation :");
        list.forEach(System.out::print);


    }
}
/*
Before Updation :
[[empID=11056, name='Devansh Sharma', salary=45000.0, project=[Project1, Project2]]
, [empID=11057, name='Shubham Negi', salary=67500.0, project=[Project1, Project2]]
, [empID=11056, name='Manish Yadav', salary=37000.0, project=[Project1, Project2]]
]
After Updation :
[empID=11056, name='Devansh Sharma', salary=55000.0, project=[Project1, Project2]]
[empID=11057, name='Shubham Negi', salary=67500.0, project=[Project1, Project2]]
[empID=11056, name='Manish Yadav', salary=37000.0, project=[Project1, Project2]]
 */