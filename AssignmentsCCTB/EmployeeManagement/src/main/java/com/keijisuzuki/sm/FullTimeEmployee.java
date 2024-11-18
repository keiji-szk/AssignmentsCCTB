package com.keijisuzuki.sm;

public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, int employeeID, double salary) {
        super(name, employeeID, salary);
    }

    @Override
    public double calculateBonus() {
        // Assuming full-time employees get a fixed percentage bonus based on salary
        return getSalary() * 0.2;  // 20% of salary as bonus
    }

    @Override
    public String toString() {
        return "Full-Time Employee; " + super.toString() ;
    }
}
