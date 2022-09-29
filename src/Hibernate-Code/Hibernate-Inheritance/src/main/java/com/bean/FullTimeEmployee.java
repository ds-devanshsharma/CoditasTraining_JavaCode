package com.bean;

public class FullTimeEmployee extends Employee{
    private int fixSalary;
    private int extra_hrs;

    public int getFixSalary() {
        return fixSalary;
    }

    public void setFixSalary(int fixSalary) {
        this.fixSalary = fixSalary;
    }

    public int getExtra_hrs() {
        return extra_hrs;
    }

    public void setExtra_hrs(int extra_hrs) {
        this.extra_hrs = extra_hrs;
    }

    public int getSalary_perHour() {
        return salary_perHour;
    }

    public void setSalary_perHour(int salary_perHour) {
        this.salary_perHour = salary_perHour;
    }

    private int salary_perHour;

    public FullTimeEmployee(int empID, String name, int fixSalary, int extra_hrs, int salary_perHour) {
        super(empID, name);
        this.fixSalary = fixSalary;
        this.extra_hrs = extra_hrs;
        this.salary_perHour = salary_perHour;
    }
}
