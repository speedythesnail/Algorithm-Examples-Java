/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.sorting;

/**
 * Merge Sort is an efficient, stable sorting algorithm that works by dividing
 * the unsorted list into n sublists, each containing one element (a list of
 * one element is considered sorted), and repeatedly merging sublists to
 * produce new sorted sublists until there is only one sublist remaining.
 *
 * Time Complexity: Worst-case, average, and best-case time complexity is
 * O(n log n) where n is the number of items being sorted.
 *
 * Space Complexity: O(n), because it requires additional space for the
 * “left” and “right” arrays in the merge process.
 *
 * When to use: Merge Sort is useful when dealing with large data sets,
 * and the stability of the sort is important (i.e., maintaining the relative
 * order of records with equal keys). It’s also effective for data structures
 * such as LinkedLists.
 *
 */
public class MergeSort {
    /**
     * Merges two subarrays of array[].
     * First subarray is array[left..middle]
     * Second subarray is array[middle+1..right]
     *
     * @param array The array to be sorted.
     * @param left The starting index of the left subarray.
     * @param middle The ending index of the left subarray and starting index of the right subarray.
     * @param right The ending index of the right subarray.
     */
    void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;

        // Create temp arrays
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        // Copy data to temp arrays
        for (int i = 0; i < leftArraySize; ++i) leftArray[i] = array[left + i];
        for (int j = 0; j < rightArraySize; ++j) rightArray[j] = array[middle + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // Initial index of merged subarray array
        int mergedIndex = left;
        while (leftIndex < leftArraySize && rightIndex < rightArraySize) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mergedIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[mergedIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        // Copy remaining elements of leftArray[] if any
        while (leftIndex < leftArraySize) {
            array[mergedIndex] = leftArray[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        // Copy remaining elements of rightArray[] if any
        while (rightIndex < rightArraySize) {
            array[mergedIndex] = rightArray[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
    }

    /**
     * Main function that sorts array[left..right] using merge()
     * It divides the array into two halves, sorts them and then merges them.
     *
     * @param array The array to be sorted.
     * @param left The starting index of the array to be sorted.
     * @param right The ending index of the array to be sorted.
     */
    void sort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }
}
