/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.search;

public class BinarySearch {
    // Method to perform Binary Search
    public int binarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            // Calculate the mid index
            int mid = left + (right - left) / 2;

            // Check if target is present at the mid index
            if (sortedArray[mid] == target) return mid;

            // If target greater, ignore left half
            if (sortedArray[mid] < target) left = mid + 1;

            // If target is smaller, ignore right half
            else right = mid - 1;
        }

        // Target is not present in array
        return -1;
    }
}
