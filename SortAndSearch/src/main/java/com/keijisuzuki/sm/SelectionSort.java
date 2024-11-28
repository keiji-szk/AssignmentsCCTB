package com.keijisuzuki.sm;

public class SelectionSort {
    public static int[] sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
