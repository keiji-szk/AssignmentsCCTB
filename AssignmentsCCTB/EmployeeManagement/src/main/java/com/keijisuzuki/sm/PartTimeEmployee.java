package com.keijisuzuki.sm;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name, int employeeID, double salary) {
        super(name, employeeID, salary);
    }

    @Override
    public double calculateBonus() {
        // Assuming part-time employees get a smaller fixed bonus
        return getSalary() * 0.1;  // 10% of salary as bonus
    }

    @Override
    public String toString() {
        return "Part-Time Employee; " + super.toString();
    }
}
