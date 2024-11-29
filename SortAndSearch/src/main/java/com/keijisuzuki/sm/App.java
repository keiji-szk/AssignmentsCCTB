package com.keijisuzuki.sm;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the number of integers
        System.out.println("Enter the number of integers you want to sort:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Step 2: Input each integer
        for (int i = 0; i < n; i++) {
            System.out.println("Enter integer " + (i + 1) + ":");
            array[i] = scanner.nextInt();
        }

        // Step 3: Choose a sorting algorithm
        System.out.println("Choose a sorting algorithm:\n1. Bubble Sort\n2. Selection Sort");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            BubbleSort.sort(array);
        } else if (choice == 2) {
            SelectionSort.sort(array);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        // Display the sorted list
        System.out.print("Sorted List: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Step 4: Search for a number in the sorted list
        System.out.println("Enter the number to search for in the sorted list:");
        int target = scanner.nextInt();
        int position = BinarySearch.search(array, target);

        if (position != -1) {
            System.out.println("Number found at position " + (position + 1) + ".");
        } else {
            System.out.println("Number not found.");
        }

        System.out.println("Thank you for using the application.");
        scanner.close();
    }
}
