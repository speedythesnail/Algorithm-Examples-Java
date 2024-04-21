/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples

import spock.lang.Specification

class MergeSortSpec extends Specification {
    def "test sort method of MergeSort"() {
        setup:
        // Create an instance of MergeSort
        MergeSort sorter = new MergeSort()

        // Define a test array
        int[] array = [5, 3, 8, 1, 2]
        // Define the expected sorted array
        int[] expected = [1, 2, 3, 5, 8]

        when:
        // Sort the test array
        sorter.sort(array, 0, array.length - 1)

        then:
        // Check if the sorted array matches the expected array
        array == expected
    }
}
