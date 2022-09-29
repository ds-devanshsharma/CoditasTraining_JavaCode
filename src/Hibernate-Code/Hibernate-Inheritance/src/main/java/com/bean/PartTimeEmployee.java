package com.bean;

public class PartTimeEmployee extends Employee{
    private int no_of_hrs;
    private int salary_per_hrs;

    public int getNo_of_hrs() {
        return no_of_hrs;
    }

    public void setNo_of_hrs(int no_of_hrs) {
        this.no_of_hrs = no_of_hrs;
    }

    public int getSalary_per_hrs() {
        return salary_per_hrs;
    }

    public void setSalary_per_hrs(int salary_per_hrs) {
        this.salary_per_hrs = salary_per_hrs;
    }

    public PartTimeEmployee(int empID, String name, int no_of_hrs, int salary_per_hrs) {
        super(empID, name);
        this.no_of_hrs = no_of_hrs;
        this.salary_per_hrs = salary_per_hrs;
    }
}
