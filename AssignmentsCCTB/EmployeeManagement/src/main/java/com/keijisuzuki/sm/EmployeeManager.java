package com.keijisuzuki.sm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();
    private HashSet<Integer> employeeIdSet = new HashSet<>();

    public boolean addEmployee(Employee employee) {
        // Ensure the employee ID is unique before adding
//        if (getEmployeeByID(employee.getEmployeeID()).isPresent()) {
//            return false;
//        }
        if (employeeIdSet.contains(employee.getEmployeeID())) {
            return false;
        }
        employees.add(employee);
        employeeIdSet.add(employee.getEmployeeID());
        return true;
    }

    public String displayAllEmployees() {
        if (employees.isEmpty()) {
            return "No employees found.";
        }
        StringBuilder employeeList = new StringBuilder();
        for (Employee employee : employees) {
            employeeList.append(employee).append("\n");
        }
        return employeeList.toString();
    }

    public boolean updateEmployeeSalary(int employeeID, double newSalary) {
        Optional<Employee> employee = getEmployeeByID(employeeID);
        if (employee.isPresent()) {
            employee.get().setSalary(newSalary);
            return true;
        }
        return false;
    }

    private Optional<Employee> getEmployeeByID(int employeeID) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeID() == employeeID)
                .findFirst();
    }
}
