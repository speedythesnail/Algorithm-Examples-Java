/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph

import spock.lang.Specification

class DepthFirstSearchSpec extends Specification {
	def depthFirstSearch = new DepthFirstSearch()

	def "DepthFirstSearch search method visits all reachable nodes from a given source node"() {
		setup:
		// Initialize a graph
		depthFirstSearch.addEdge(0, 1)
		depthFirstSearch.addEdge(0, 2)
		depthFirstSearch.addEdge(1, 2)
		depthFirstSearch.addEdge(2, 0)
		depthFirstSearch.addEdge(2, 3)
		depthFirstSearch.addEdge(3, 3)

		// Expected order of visited nodes
		List<Integer> expectedOrder = [2, 3, 0, 1]

		when:
		// Call the search method of the DepthFirstSearch class
		List<Integer> actualOrder = depthFirstSearch.depthFirstSearch(2)

		then:
		// Check if the actual order of visited nodes matches the expected order
		actualOrder == expectedOrder
	}
}
