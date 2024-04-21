/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples;

/**
 * Bubble Sort is a simple sorting algorithm that repeatedly steps through
 * the list, compares adjacent elements and swaps them if they are in the
 * wrong order. The pass through the list is repeated until the list is sorted.
 *
 * Time Complexity: Worst-case and average complexity is O(n^2) where n is the
 * number of items being sorted. Best case (already sorted list) is O(n).
 *
 * Space Complexity: O(1), because it only requires a single additional memory
 * space for temp variable.
 *
 * When to use: Bubble Sort can be used when the input size is small, and space
 * complexity is a concern. It’s also useful for educational purposes due to
 * its simplicity.
 *
 */
public class BubbleSort {
    // Method to perform Bubble Sort
    public void sort(int[] arrayToSort) {
        int arrayLength = arrayToSort.length;

        // Loop over the array
        for (int i = 0; i < arrayLength - 1; i++) {
            // Last i elements are already sorted
            for (int j = 0; j < arrayLength - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }
    }
}
