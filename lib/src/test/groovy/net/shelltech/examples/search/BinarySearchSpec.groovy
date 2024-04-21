/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.search

import spock.lang.Specification

class BinarySearchSpec extends Specification {
	def binarySearch = new BinarySearch()

	def "BinarySearch search method finds the target in a sorted array"() {
		setup:
		// Initialize a sorted array of integers for searching
		int[] sortedArray = [11, 12, 22, 25, 34, 64, 90]
		int target = 25
		int expectedIndex = 3

		when:
		// Call the search method of the BinarySearch class
		int actualIndex = binarySearch.binarySearch(sortedArray, target)

		then:
		// Check if the returned index is the expected index
		actualIndex == expectedIndex
	}
}
