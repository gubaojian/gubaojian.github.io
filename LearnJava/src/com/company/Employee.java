package com.company;

public class Employee {

    public String department;
    public int id;

    public Employee(int id, String department) {
        this.id = id;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
