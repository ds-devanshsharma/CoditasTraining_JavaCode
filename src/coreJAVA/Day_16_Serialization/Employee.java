package coreJAVA.Day_16_Serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    int id;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }

    String name;
    float sal;

    public Employee(int id, String name, float sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }
}
