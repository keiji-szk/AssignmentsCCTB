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

        // Step 1: Get the list of integers from the user
        System.out.println("Enter a list of integers (space-separated):");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] array = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            array[i] = Integer.parseInt(inputArray[i]);
        }

        // Step 2: Prompt user to select a sorting algorithm
        System.out.println("Choose a sorting algorithm:\n1. Bubble Sort\n2. Selection Sort");
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
        System.out.println("Sorted list:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Step 3: Search for a target integer
        System.out.println("Enter an integer to search for:");
        int target = scanner.nextInt();
        boolean found = BinarySearch.search(array, target);

        if (found) {
            System.out.println("The integer " + target + " was found in the list.");
        } else {
            System.out.println("The integer " + target + " was not found in the list.");
        }

        scanner.close();
    }
}
