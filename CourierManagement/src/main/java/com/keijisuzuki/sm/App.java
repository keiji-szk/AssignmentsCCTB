package com.keijisuzuki.sm;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourierManager manager = new CourierManager();

        while (true) {
            System.out.println("\n===============================");
            System.out.println(" Welcome to Delivery Dilemmas!");
            System.out.println("===============================");
            System.out.println("1. Add a new package");
            System.out.println("2. Display all packages and shipping costs");
            System.out.println("3. Sort packages by weight");
            System.out.println("4. Search for a package by Tracking ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Enter package type (Standard/Express): ");
                        String packageType = scanner.nextLine().trim().toLowerCase();
                        System.out.print("Enter tracking ID: ");
                        String trackingID = scanner.nextLine().trim();
                        System.out.print("Enter destination: ");
                        String destination = scanner.nextLine().trim();
                        System.out.print("Enter weight: ");
                        double weight = Double.parseDouble(scanner.nextLine().trim());

                        Package pkg;
                        if (packageType.equals("standard")) {
                            pkg = new StandardPackage(trackingID, destination, weight);
                        } else if (packageType.equals("express")) {
                            pkg = new ExpressPackage(trackingID, destination, weight);
                        } else {
                            System.out.println("Invalid package type. Please choose either 'Standard' or 'Express'.");
                            continue;
                        }

                        manager.addPackage(pkg);
                        System.out.println("Package added successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "2":
                    manager.displayPackages();
                    break;

                case "3":
                    manager.sortPackagesByWeight();
                    manager.displayPackages();
                    break;

                case "4":
                    System.out.print("Enter Tracking ID: ");
                    String trackingID = scanner.nextLine().trim();
                    Package pkg = manager.searchPackageByTrackingID(trackingID);
                    if (pkg != null) {
                        System.out.println("Package Found:");
                        System.out.println(pkg.toString());
                    } else {
                        System.out.println("Package not found.");
                    }
                    break;

                case "5":
                    System.out.println("Thank you for using Delivery Dilemmas!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

