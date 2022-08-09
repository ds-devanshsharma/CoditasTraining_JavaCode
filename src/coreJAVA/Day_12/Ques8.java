package coreJAVA.Day_12;
/**
 * Using Constructor try to Reinitialize values of class
 * Employee(emp id,emp_name,emp_address,emp_sal)
 */
class Employee{
    int id;
    String name;
    String address;
    float salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(int id, String name, String address, float salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }
}
public class Ques8 {
    public static void main(String[] args) {
        Employee employee = new Employee(101,"Devansh","Kanpur",12000);
        System.out.println(employee);
    }
}
/**
 * Employee{id=101, name='Devansh', address='Kanpur', salary=12000.0}
 */