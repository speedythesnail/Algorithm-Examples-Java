/* (C) 2024 ShellTech.net, All Rights Reserved. */
package net.shelltech.examples.graph;

import java.util.*;

/**
 * This class represents a Depth-First Search (DFS) algorithm on a graph.
 * The graph is represented as an adjacency list using a HashMap.
 */
public class DepthFirstSearch {
    // Graph represented as an adjacency list
    private HashMap<Integer, List<Integer>> graph;

    /**
     * Constructor for the DepthFirstSearch class.
     * Initializes the graph as a new HashMap.
     */
    public DepthFirstSearch() {
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
     * Method to perform Depth-First Search from a given source node.
     *
     * @param source The source node from where DFS should start.
     * @return A list of nodes in the order they were visited during the DFS.
     */
    public List<Integer> depthFirstSearch(int source) {
        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Mark the current node as visited and push it to the stack
        HashSet<Integer> visited = new HashSet<>();
        visited.add(source);
        stack.push(source);

        // List to store the order of visited nodes
        List<Integer> orderOfVisitedNodes = new ArrayList<>();

        while (!stack.isEmpty()) {
            // Pop a vertex from stack and add it to the result list
            int node = stack.pop();
            orderOfVisitedNodes.add(node);

            // Get all adjacent vertices of the popped vertex
            // If an adjacent vertex has not been visited, then mark it visited and push it to the stack
            List<Integer> neighbours = graph.get(node);
            if (neighbours != null) {
                for (int neighbour : neighbours) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        stack.push(neighbour);
                    }
                }
            }
        }

        // Return the order of visited nodes
        return orderOfVisitedNodes;
    }
}
