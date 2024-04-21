/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph

import net.shelltech.examples.graph.FloydWarshallAlgorithm

import spock.lang.Specification

class FloydWarshallAlgorithmSpec extends Specification {
	FloydWarshallAlgorithm floydWarshallAlgorithm = new FloydWarshallAlgorithm()

	def "FloydWarshallAlgorithm method returns shortest distances between every pair of vertices"() {
		setup:
		// Initialize a graph as adjacency matrix
		int[][] graph = [
			[
				0,
				5,
				FloydWarshallAlgorithm.INF,
				10
			],
			[
				FloydWarshallAlgorithm.INF,
				0,
				3,
				FloydWarshallAlgorithm.INF
			],
			[
				FloydWarshallAlgorithm.INF,
				FloydWarshallAlgorithm.INF,
				0,
				1
			],
			[
				FloydWarshallAlgorithm.INF,
				FloydWarshallAlgorithm.INF,
				FloydWarshallAlgorithm.INF,
				0
			]
		]

		// Expected shortest distances between every pair of vertices
		int[][] expectedDistances = [
			[0, 5, 8, 9],
			[
				FloydWarshallAlgorithm.INF,
				0,
				3,
				4
			],
			[
				FloydWarshallAlgorithm.INF,
				FloydWarshallAlgorithm.INF,
				0,
				1
			],
			[
				FloydWarshallAlgorithm.INF,
				FloydWarshallAlgorithm.INF,
				FloydWarshallAlgorithm.INF,
				0
			]
		]

		when:
		// Call the floydWarshall method of the FloydWarshallAlgorithm class
		int[][] actualDistances = floydWarshallAlgorithm.floydWarshall(graph)

		then:
		// Check if the actual shortest distances match the expected shortest distances
		actualDistances == expectedDistances
	}
}
