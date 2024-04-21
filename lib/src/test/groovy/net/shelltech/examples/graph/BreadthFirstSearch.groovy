/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph

import spock.lang.Specification

class BreadthFirstSearchSpec extends Specification {
	def breadthFirstSearch = new BreadthFirstSearch()

	def "BreadthFirstSearch search method visits all reachable nodes from a given source node"() {
		setup:
		// Initialize a graph
		breadthFirstSearch.addEdge(0, 1)
		breadthFirstSearch.addEdge(0, 2)
		breadthFirstSearch.addEdge(1, 2)
		breadthFirstSearch.addEdge(2, 0)
		breadthFirstSearch.addEdge(2, 3)
		breadthFirstSearch.addEdge(3, 3)

		// Expected order of visited nodes
		List<Integer> expectedOrder = [2, 0, 3, 1]

		when:
		// Call the search method of the BreadthFirstSearch class
		List<Integer> actualOrder = breadthFirstSearch.breadthFirstSearch(2)

		then:
		// Check if the actual order of visited nodes matches the expected order
		actualOrder == expectedOrder
	}
}
