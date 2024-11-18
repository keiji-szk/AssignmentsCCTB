package com.keijisuzuki.sm;

import java.util.Scanner;

public class UserPrompt {

    static UserSelectCommand getUserSelectCommand() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1: Add Employee\n" +
                    "2: Display All Employees\n" +
                    "3: Update an employee's salary\n" +
                    "4: Quit");
            System.out.print("Select command: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            int selectNumber = scanner.nextInt();

            switch (selectNumber) {
                case 1:
                    return UserSelectCommand.ADD_EMPLOYEE;
                case 2:
                    return UserSelectCommand.DISPLAY_ALL_EMPLOYEES;
                case 3:
                    return UserSelectCommand.UPDATE_SALARY;
                case 4:
                    return UserSelectCommand.QUIT;
                default:
                    System.out.println("Invalid selection. Please select a valid option.");
            }
        }
    }

    static Employee getNewEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Is the employee full-time? (Enter 'y' for Yes, otherwise part-time): ");
        boolean isFullTime = scanner.next().equalsIgnoreCase("y");
        scanner.nextLine();

        // Retrieve employee's name
        String inputName;
        do {
            System.out.print("Enter employee's name: ");
            inputName = scanner.nextLine();
        } while (inputName.isEmpty());

        // Retrieve employee ID
        int inputID = -1;
        do {
            System.out.print("Enter employee ID (number only): ");
            if (scanner.hasNextInt()) {
                inputID = scanner.nextInt();
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();  // Consume invalid input
            }
        } while (inputID < 0);

        // Retrieve salary
        double inputSalary = -1;
        do {
            System.out.print("Enter salary: ");
            if (scanner.hasNextDouble()) {
                inputSalary = scanner.nextDouble();
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();  // Consume invalid input
            }
        } while (inputSalary < 0);

        if (isFullTime) {
            return new FullTimeEmployee(inputName, inputID, inputSalary);
        } else {
            return new PartTimeEmployee(inputName, inputID, inputSalary);
        }
    }

    static int getEmployeeID() {
        Scanner scanner = new Scanner(System.in);
        int employeeID;
        do {
            System.out.print("Enter employee ID: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
            employeeID = scanner.nextInt();
        } while (employeeID < 0);
        return employeeID;
    }

    static double getSalary() {
        Scanner scanner = new Scanner(System.in);
        double salary;
        do {
            System.out.print("Enter salary: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
            salary = scanner.nextDouble();
        } while (salary < 0);
        return salary;
    }
}
