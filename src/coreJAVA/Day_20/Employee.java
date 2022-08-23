package coreJAVA.Day_20;

import static coreJAVA.Day_20.EmployeeSystemDriver.count;

class Employee {
    int empID;
    String name;
    String city;

    public Employee(int empID, String name, String city) {
        this.empID = empID;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee "+"[" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ']';
    }
}

