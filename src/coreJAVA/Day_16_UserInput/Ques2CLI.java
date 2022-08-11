package coreJAVA.Day_16_UserInput;
class Employee{
    int id;
    String name;
    float salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}
public class Ques2CLI {
    //input from CommandLine
    public static void inputDetailsfromCLI(String[] args,Employee employee){
        employee.id = Integer.parseInt(args[0]);
        employee.name =args[1];
        employee.salary = Float.parseFloat(args[2]);
    }
    public static void printDetails(Employee employee){
        System.out.println(employee.toString());
    }

}

/*
Employee{id=101, name='Devansh', salary=45000.0}

 */