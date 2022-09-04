package Stream.StreamPractice;
/**
 * Employee POJO
 */

import java.util.ArrayList;
import java.util.List;

public class Employee {
   private int empID;
   private String name;
   private double salary;
   private List<String > project ;

   public Employee(int empID, String name, double salary, List<String> project) {
    this.empID = empID;
    this.name = name;
    this.salary = salary;
    this.project = project;
   }

    public int getEmpID() {
     return empID;
    }

    public void setEmpID(int empID) {
     this.empID = empID;
    }

    public String getName() {
     return name;
    }

    public void setName(String name) {
     this.name = name;
    }

    public double getSalary() {
     return salary;
    }

    public void setSalary(double salary) {
     this.salary = salary;
    }

    public List<String> getProject() {
     return project;
    }

    public void setProject(List<String> project) {
     this.project = project;
    }

 @Override
 public String toString() {
  return "[" +
          "empID=" + empID +
          ", name='" + name + '\'' +
          ", salary=" + salary +
          ", project=" + project +
          ']'+"\n";
 }
 public static List<Employee> empDefaultList(){
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(11056,"Devansh Sharma",45000.0,List.of("Project1","Project2")));
    employees.add(new Employee(11057,"Shubham Negi",67500.0,List.of("Project1","Project2")));
    employees.add(new Employee(11056,"Manish Yadav",37000.0,List.of("Project1","Project2")));
    return employees;
 }
}
