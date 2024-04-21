/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph

import spock.lang.Specification

class DijkstraAlgorithmSpec extends Specification {
	DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm()

	def "DijkstraAlgorithm search method returns shortest distances from a given source node"() {
		setup:
		// Initialize a graph as adjacency matrix
		int[][] graph = [
			[0, 4, 0, 0, 0, 0, 0, 8, 0],
			[4, 0, 8, 0, 0, 0, 0, 11, 0],
			[0, 8, 0, 7, 0, 4, 0, 0, 2],
			[0, 0, 7, 0, 9, 14, 0, 0, 0],
			[0, 0, 0, 9, 0, 10, 0, 0, 0],
			[0, 0, 4, 14, 10, 0, 2, 0, 0],
			[0, 0, 0, 0, 0, 2, 0, 1, 6],
			[8, 11, 0, 0, 0, 0, 1, 0, 7],
			[0, 0, 2, 0, 0, 0, 6, 7, 0]
		]

		// Expected shortest distances from source node 0
		int[] expectedDistances = [
			0,
			4,
			12,
			19,
			21,
			11,
			9,
			8,
			14
		]

		when:
		// Call the search method of the DijkstraAlgorithm class
		int[] actualDistances = dijkstraAlgorithm.dijkstra(graph, 0)

		then:
		// Check if the actual shortest distances match the expected shortest distances
		actualDistances == expectedDistances
	}
}
