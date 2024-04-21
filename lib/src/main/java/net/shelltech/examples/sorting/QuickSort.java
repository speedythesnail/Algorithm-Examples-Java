/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.sorting;

/**
 * Quick Sort is a divide and conquer algorithm. It picks an element as pivot
 * and partitions the given array around the picked pivot.
 */
public class QuickSort {

    /**
     * Method to perform QuickSort on an array.
     * It picks a pivot element, partitions the array around the pivot, and then recursively sorts the partitions.
     *
     * @param arrayToSort The array to be sorted.
     * @param low The starting index for the sort.
     * @param high The ending index for the sort.
     */
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

    /**
     * This function takes last element as pivot, places the pivot element at its correct position in sorted array,
     * and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot.
     *
     * @param arrayToSort The array to be partitioned.
     * @param low The starting index for the partition.
     * @param high The ending index for the partition (pivot element).
     * @return The index of the pivot element.
     */
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
