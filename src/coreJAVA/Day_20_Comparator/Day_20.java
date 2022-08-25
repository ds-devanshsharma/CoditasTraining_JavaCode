package coreJAVA.Day_20_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Comparator
class Employee1{
    int empID;
    String name ;

    public Employee1(int empID, String name) {
        this.empID = empID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                '}';
    }
}
class SortingEmployee1 implements Comparator<Employee1> {


    @Override
    public int compare(Employee1 o1, Employee1 o2) {
        return o1.empID- o2.empID;
    }

}
public class Day_20 {
    public static void main(String[] args) {
        List<Employee1> list = new ArrayList<>();
        list.add(new Employee1(101,"Devansh"));
        list.add(new Employee1(102,"Himanshu"));
        list.add(new Employee1(103,"Baniya"));
        list.add(new Employee1(104,"Manu"));
        list.add(new Employee1(105,"Negi"));

        //printing before sort
        for(int i=0 ;i<list.size() ;i++)
            System.out.println(list.get(i));

        //sorting
        Collections.sort(list,new SortingEmployee1());

        // printing after sorting
        System.out.println("*********************");
        System.out.println("After Sorting on the basis :: ");
        for(int i=0 ;i<list.size() ;i++)
            System.out.println(list.get(i));
    }
}
