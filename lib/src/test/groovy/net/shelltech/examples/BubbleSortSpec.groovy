/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples

import spock.lang.Specification

class BubbleSortSpec extends Specification {
	def bubbleSort = new BubbleSort()

	def "BubbleSort sort method sorts an array in ascending order"() {
		setup:
		// Initialize an array of integers for sorting
		int[] unsortedArray = [64, 34, 25, 12, 22, 11, 90]
		int[] expectedSortedArray = [11, 12, 22, 25, 34, 64, 90]

		when:
		// Call the sort method of the BubbleSort class
		bubbleSort.sort(unsortedArray)

		then:
		// Check if the array is sorted in ascending order
		unsortedArray == expectedSortedArray
	}
}
