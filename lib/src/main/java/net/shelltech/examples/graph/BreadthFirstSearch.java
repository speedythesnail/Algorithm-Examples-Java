/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph;

import java.util.*;

/**
 * This class represents a Breadth-First Search (BFS) algorithm on a graph.
 * The graph is represented as an adjacency list using a HashMap.
 */
public class BreadthFirstSearch {
    // Graph represented as an adjacency list
    private HashMap<Integer, List<Integer>> graph;

    /**
     * Constructor for the BreadthFirstSearch class.
     * Initializes the graph as a new HashMap.
     */
    public BreadthFirstSearch() {
        this.graph = new HashMap<>();
    }

    /**
     * Method to add an edge to the graph.
     *
     * @param node The node to which an edge should be added.
     * @param neighbour The neighbour node that should be connected by the edge.
     */
    public void addEdge(int node, int neighbour) {
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        graph.get(node).add(neighbour);
    }

    /**
     * Method to perform Breadth-First Search from a given source node.
     *
     * @param source The source node from where BFS should start.
     * @return A list of nodes in the order they were visited during the BFS.
     */
    public List<Integer> breadthFirstSearch(int source) {
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        HashSet<Integer> visited = new HashSet<>();
        visited.add(source);
        queue.add(source);

        // List to store the order of visited nodes
        List<Integer> orderOfVisitedNodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and add it to the result list
            int node = queue.poll();
            orderOfVisitedNodes.add(node);

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, then mark it visited and enqueue it
            List<Integer> neighbours = graph.get(node);
            if (neighbours != null) {
                for (int neighbour : neighbours) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        // Return the order of visited nodes
        return orderOfVisitedNodes;
    }
}
