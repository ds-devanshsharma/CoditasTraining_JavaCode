package com.entities;

import javax.persistence.*;

@Entity
public class Employee {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_ID")
    private int empId;
    @Column(name = "Username")
    private String userName;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", userName='" + userName + '\'' +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Embedded
     private Address address;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
