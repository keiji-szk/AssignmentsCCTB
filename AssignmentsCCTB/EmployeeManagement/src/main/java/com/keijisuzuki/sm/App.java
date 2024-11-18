package com.keijisuzuki.sm;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Employee Management System");

        boolean flagContinue = true;
        EmployeeManager manager = new EmployeeManager();

        while (flagContinue) {
            // Get the user command from UserPrompt
            UserSelectCommand command = UserPrompt.getUserSelectCommand();

            switch (command) {
                case ADD_EMPLOYEE:
                    addEmployeeProcess(manager);
                    break;

                case DISPLAY_ALL_EMPLOYEES:
                    System.out.println(manager.displayAllEmployees());
                    break;

                case UPDATE_SALARY:
                    updateEmployeeSalaryProcess(manager);
                    break;

                case QUIT:
                    System.out.println("Bye!");
                    flagContinue = false;
                    break;
            }
        }
    }

    private static void addEmployeeProcess(EmployeeManager manager) {
        while (true) {
            Employee employee = UserPrompt.getNewEmployee();
            if (manager.addEmployee(employee)) {
                break;
            }
            System.out.println("Failed to add an employee. Please type a unique employee ID.");
        }
    }

    private static void updateEmployeeSalaryProcess(EmployeeManager manager) {
        while (true) {
            Integer employeeID = UserPrompt.getEmployeeID();
            Double salary = UserPrompt.getSalary();
            if (manager.updateEmployeeSalary(employeeID, salary)) {
                break;
            }
            System.out.println("Failed to update salary. Please type an existing employee ID.");
        }
    }
}
