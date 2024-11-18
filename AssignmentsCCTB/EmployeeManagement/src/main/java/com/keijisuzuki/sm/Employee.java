package com.keijisuzuki.sm;

public abstract class Employee implements BonusCalculable {
    private String name;
    private int employeeID;
    private double salary;

    public Employee(String name, int employeeID, double salary) {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeID: " + employeeID + ", Name: " + name + ", Salary: " + salary + ", Bonus: " + calculateBonus();
    }
}
