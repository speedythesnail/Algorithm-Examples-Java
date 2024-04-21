/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph;

import java.util.*;

public class BreadthFirstSearch {
    // Graph represented as an adjacency list
    private HashMap<Integer, List<Integer>> graph;

    public BreadthFirstSearch() {
        this.graph = new HashMap<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int node, int neighbour) {
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        graph.get(node).add(neighbour);
    }

    // Method to perform Breadth-First Search from a given source node
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
