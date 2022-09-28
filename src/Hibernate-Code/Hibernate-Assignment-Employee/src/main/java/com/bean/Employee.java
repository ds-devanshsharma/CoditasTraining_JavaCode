package com.bean;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeTable")
public class Employee {
    @Id
    private int empID;
    private String name;
    private String designation;
    @ColumnDefault("2000.00")
    private float salary;



    @Column(name = "City")
    @ColumnDefault("'Kanpur'")
    private String city ;

    @Override
    public String toString() {
        return
                "[ empID=" + empID +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary + "\' " +
                   "City = "+city+" ]";
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
