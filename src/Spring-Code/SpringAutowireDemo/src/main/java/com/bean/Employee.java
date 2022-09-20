package com.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
    int id;
    String name;

    Address eAddress;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eAddress=" + eAddress +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address geteAddress() {
        return eAddress;
    }

    public void seteAddress(Address eAddress) {
        this.eAddress = eAddress;
    }

    public Employee() {
    }
}
