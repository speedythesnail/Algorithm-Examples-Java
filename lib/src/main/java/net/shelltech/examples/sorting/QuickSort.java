/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.sorting;

public class QuickSort {

    // Method to perform QuickSort
    public void quickSort(int[] arrayToSort, int low, int high) {
        if (low < high) {
            // Find pivot element such that elements smaller than pivot are on the left and elements greater are on the
            // right
            int pivotIndex = partition(arrayToSort, low, high);

            // Recursively call quicksort on the two halves: before pivot and after pivot
            quickSort(arrayToSort, low, pivotIndex - 1);
            quickSort(arrayToSort, pivotIndex + 1, high);
        }
    }

    // This function takes last element as pivot, places the pivot element at its correct position in sorted array,
    // and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    private int partition(int[] arrayToSort, int low, int high) {
        // Pivot is the far right element
        int pivot = arrayToSort[high];

        // Index of smaller element
        int smallerElementIndex = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arrayToSort[j] <= pivot) {
                smallerElementIndex++;

                // Swap arrayToSort[smallerElementIndex] and arrayToSort[j]
                int temp = arrayToSort[smallerElementIndex];
                arrayToSort[smallerElementIndex] = arrayToSort[j];
                arrayToSort[j] = temp;
            }
        }

        // Swap arrayToSort[smallerElementIndex+1] and arrayToSort[high] (or pivot)
        int temp = arrayToSort[smallerElementIndex + 1];
        arrayToSort[smallerElementIndex + 1] = arrayToSort[high];
        arrayToSort[high] = temp;

        return smallerElementIndex + 1;
    }
}
