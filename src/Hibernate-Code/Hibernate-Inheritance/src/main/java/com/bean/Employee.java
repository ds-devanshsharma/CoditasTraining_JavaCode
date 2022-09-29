package com.bean;

public class Employee {
    private int empID;
    private String name;

    public Employee(int empID, String name) {
        this.empID = empID;
        this.name = name;
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
}
